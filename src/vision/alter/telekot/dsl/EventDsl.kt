package vision.alter.telekot.dsl

import vision.alter.telekot.telegram.model.Chat
import vision.alter.telekot.telegram.model.Message
import vision.alter.telekot.telegram.model.User

/**
 *
 */
@BotDslMarker
@SuppressWarnings("LateinitUsage")
data class EventDsl(
    internal val command: CommandDsl,
    val message: Message,
    val user: User,
    val chat: Chat
) {
    val context: ContextDsl
        get() = internalContext
    internal lateinit var internalContext: ContextDsl

    /**
     *
     */
    suspend fun answer(text: String, replyTo: Boolean = false) {
        command.bot.apiClient.commonApi.sendMessage(
            chatId = message.chat.id.toString(),
            text = text,
            replyToMessageId = message.messageId.takeIf { replyTo }
        )
    }
}
