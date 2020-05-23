package org.marshalov.telekot.telegram.api

import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.Message
import org.marshalov.telekot.telegram.model.games.GameHighScore

/**
 * Interface for Games Telegram Bot API (https://core.telegram.org/bots/api#games).
 */
interface GamesBotApi : TelegramApi {
    /**
     * Use this method to send a game (https://core.telegram.org/bots/api#sendgames).
     * @param chatId Unique identifier for the target chat
     * @param gameShortName Short name of the game, serves as the unique identifier for the game. Set up your games via Botfather.
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup A JSON-serialized object for an inline keyboard. If empty, one ‘Play gameTitle’ button will be shown. If not empty, the first button must launch the game.
     * @return sent Message
     */
    suspend fun sendGame(
        chatId: Long,
        gameShortName: String,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * Use this method to set the score of the specified user in a game (https://core.telegram.org/bots/api#setgamescore).
     * On success, if the message was sent by the bot, returns the edited Message, otherwise returns True.
     * Returns an error, if the new score is not greater than the user's current score in the chat and force is False.
     * @param userId User identifier
     * @param score New score, must be non-negative
     * @param force Pass True, if the high score is allowed to decrease. This can be useful when fixing mistakes or banning cheaters
     * @param disableEditMessage Pass True, if the game message should not be automatically edited to include the current scoreboard
     * @param chatId Required if inlineMessageId is not specified. Unique identifier for the target chat
     * @param messageId Required if inlineMessageId is not specified. Identifier of the sent message
     * @param inlineMessageId Required if chatId and messageId are not specified. Identifier of the inline message
     * @return the edited Message
     */
    suspend fun setGameScore(
        userId: Long,
        score: Long,
        force: Boolean? = null,
        disableEditMessage: Boolean? = null,
        chatId: Long? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null
    ): Message

    /**
     * Use this method to get data for high score tables (https://core.telegram.org/bots/api#getgamehighscores).
     * Will return the score of the specified user and several of their neighbors in a game.
     * This method will currently return scores for the target user, plus two of their closest neighbors on each side.
     * Will also return the top three users if the user and his neighbors are not among them.
     * Please note that this behavior is subject to change.
     * @param userId Target user id
     * @param chatId Required if inlineMessageId is not specified. Unique identifier for the target chat
     * @param messageId Required if inlineMessageId is not specified. Identifier of the sent message
     * @param inlineMessageId Required if chatId and messageId are not specified. Identifier of the inline message
     * @return a List of GameHighScore objects
     */
    suspend fun getGameHighScores(
        userId: Long,
        chatId: Long? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null
    ): List<GameHighScore>
}
