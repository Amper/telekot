package vision.alter.telekot.client.clients

import io.ktor.client.HttpClient
import vision.alter.telekot.telegram.api.GamesBotApi
import vision.alter.telekot.telegram.model.InlineKeyboardMarkup
import vision.alter.telekot.telegram.model.Message
import vision.alter.telekot.telegram.model.games.GameHighScore

/**
 * Games Telegram Bot API implementation.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 */
class GamesBotApiClient(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) : GamesBotApi {

    override suspend fun sendGame(
        chatId: Long,
        gameShortName: String,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::sendGame, mapOf(
                "chat_id" to chatId,
                "game_short_name" to gameShortName,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun setGameScore(
        userId: Long,
        score: Long,
        force: Boolean?,
        disableEditMessage: Boolean?,
        chatId: Long?,
        messageId: Long?,
        inlineMessageId: String?
    ): Message =
        api.getMethodResult(
            ::setGameScore, mapOf(
                "user_id" to userId,
                "score" to score,
                "force" to force,
                "disable_edit_message" to disableEditMessage,
                "chat_id" to chatId,
                "message_id" to messageId,
                "inline_message_id" to inlineMessageId
            )
        )

    override suspend fun getGameHighScores(
        userId: Long,
        chatId: Long?,
        messageId: Long?,
        inlineMessageId: String?
    ): List<GameHighScore> =
        api.getMethodResult(
            ::getGameHighScores, mapOf(
                "user_id" to userId,
                "chat_id" to chatId,
                "message_id" to messageId,
                "inline_message_id" to inlineMessageId
            )
        )

    // ------------------------------------------------------------------------------------------------------------- //

    private val api = ApiClientWrapper(apiToken, apiUrl, client)
}
