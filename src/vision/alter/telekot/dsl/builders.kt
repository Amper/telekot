package vision.alter.telekot.dsl

import vision.alter.telekot.client.BotApiClient
import vision.alter.telekot.client.invoke
import vision.alter.telekot.core.Bot
import vision.alter.telekot.core.bots.AbstractBot
import vision.alter.telekot.core.bots.LongPoolingBot
import vision.alter.telekot.core.updates.LongPoolingUpdateProvider
import vision.alter.telekot.telegram.model.updates.Update

/**
 *
 */
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
