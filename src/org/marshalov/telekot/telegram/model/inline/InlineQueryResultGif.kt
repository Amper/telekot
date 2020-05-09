package org.marshalov.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a link to an animated GIF file (https://core.telegram.org/bots/api#inlinequeryresultgif).
 * By default, this animated GIF file will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified
 * content instead of the animation.
 */
@Serializable
data class InlineQueryResultGif(
    /**
     * Type of the result, must be gif
     */
    val type: String = "gif",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid URL for the GIF file. File size must not exceed 1MB
     */
    val gifUrl: String = "",
    /**
     * Optional. Width of the GIF
     */
    val gifWidth: Int? = null,
    /**
     * Optional. Height of the GIF
     */
    val gifHeight: Int? = null,
    /**
     * Optional. Duration of the GIF
     */
    val gifDuration: Int? = null,
    /**
     * URL of the static thumbnail for the result (jpeg or gif)
     */
    val thumbUrl: String? = null,
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
