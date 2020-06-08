package vision.alter.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.InlineKeyboardMarkup
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a Game (https://core.telegram.org/bots/api#inlinequeryresultgame).
 */
@Serializable
data class InlineQueryResultGame(
    /**
     * Type of the result, must be game
     */
    val type: String = "game",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * Short name of the game
     */
    val gameShortName: String = "",
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null
) : TelegramObject,
    InlineQueryResult
