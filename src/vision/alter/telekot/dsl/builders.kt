package vision.alter.telekot.dsl

import vision.alter.telekot.client.BotApiClient
import vision.alter.telekot.core.Bot
import vision.alter.telekot.core.bots.AbstractBot
import vision.alter.telekot.core.bots.LongPoolingBot
import vision.alter.telekot.core.updates.LongPoolingUpdateProvider
import vision.alter.telekot.telegram.model.Chat
import vision.alter.telekot.telegram.model.Message
import vision.alter.telekot.telegram.model.User
import vision.alter.telekot.telegram.model.updates.Update

@DslMarker
internal annotation class BotDslMarker

@BotDslMarker
fun bot(init: BotDsl.() -> Unit): Bot =
    BotDsl()
        .let { bot ->
            bot.init()
            return when (val updatingType = bot.updatingType) {
                is LongPooling -> run {
                    val apiToken = bot.apiToken ?: throw RuntimeException("No token specified!")
                    val apiUrl = bot.apiUrl
                    bot.apiClient = BotApiClient(apiToken, apiUrl)
                    LongPoolingBot(apiToken, apiUrl, bot.apiClient,
                        updateProvider = LongPoolingUpdateProvider(
                            apiClient = bot.apiClient,
                            batchSize = updatingType.batchSize,
                            poolSize = updatingType.poolSize,
                            timeout = updatingType.timeout
                        ),
                        updateHandler = { update -> this.handleEvent(bot, update) }
                    )
                }
                is WebHook -> TODO("Not implemented")
            }
        }

sealed class BotUpdatingType
data class LongPooling(val batchSize: Long = 100, val poolSize: Int = 4, val timeout: Long = 1) : BotUpdatingType()
object WebHook : BotUpdatingType()

@BotDslMarker
data class BotDsl(
    var updatingType: BotUpdatingType = LongPooling(),
    var apiToken: String? = null,
    var apiUrl: String? = null
) {
    internal val commands: MutableSet<CommandDsl> = HashSet()
    internal var unknownCommandHandler: suspend (event: EventDsl) -> Unit = {}
    internal lateinit var apiClient: BotApiClient

    fun command(name: String, description: String = "", handler: suspend CommandDsl.(event: EventDsl) -> Unit) =
        CommandDsl(this, name, description, handler).let(commands::add)

    fun unknownCommand(handler: suspend (event: EventDsl) -> Unit) {
        unknownCommandHandler = handler
    }
}

@BotDslMarker
data class CommandDsl(
    internal val bot: BotDsl,
    val name: String,
    val description: String = "",
    val handler: suspend CommandDsl.(event: EventDsl) -> Unit
)

@BotDslMarker
data class EventDsl(
    internal val command: CommandDsl,
    val message: Message,
    val user: User,
    val chat: Chat
) {
    val context: ContextDsl
        get() = internalContext
    internal lateinit var internalContext: ContextDsl
    suspend fun answer(text: String, replyTo: Boolean = false) {
        command.bot.apiClient.commonApi.sendMessage(
            chatId = message.chat.id.toString(),
            text = text,
            replyToMessageId = message.messageId.takeIf { replyTo }
        )
    }
}

@BotDslMarker
data class ContextDsl(
    internal val event: EventDsl,
    val history: List<Message>
)

private suspend inline fun AbstractBot.handleEvent(bot: BotDsl, update: Update) {
    val message = update.message
    val text = message?.text
    when {
        text == null -> return // @TODO
        text.startsWith("/") -> run {
            val command = bot.commands
                .firstOrNull {
                        cmd -> text.startsWith("/${cmd.name}")
                }
            val event = EventDsl(
                command = command ?: CommandDsl(bot, name = text, handler = {}),
                message = message,
                user = message.from,
                chat = message.chat
            ).also { event ->
                event.internalContext = ContextDsl(event, emptyList())
            }
            when (command) {
                null -> bot.unknownCommandHandler(event)
                else -> command.handler(command, event)
            }
        }
        else -> return // @TODO
    }
}
