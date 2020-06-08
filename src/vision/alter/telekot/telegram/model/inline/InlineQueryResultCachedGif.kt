package vision.alter.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.InlineKeyboardMarkup
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a link to an animated GIF file stored on the Telegram servers.
 * (https://core.telegram.org/bots/api#inlinequeryresultcachedgif)
 * By default, this animated GIF file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with specified content instead of the animation.
 */
@Serializable
data class InlineQueryResultCachedGif(
    /**
     * Type of the result, must be gif
     */
    val type: String = "gif",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid file identifier for the GIF file
     */
    val gifFileId: String = "",
    /**
     * Optional. Title for the result
     */
    val title: String? = null,
    /**
     * Optional. Caption of the GIF file to be sent, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the caption. See formatting options for more details.
     */
    val parseMode: String? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the GIF animation
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
