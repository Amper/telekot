package org.marshalov.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a link to a video animation (H.264/MPEG-4 AVC video without sound).
 * (https://core.telegram.org/bots/api#inlinequeryresultmpeg4gif)
 * By default, this animated MPEG-4 file will be sent by the user with optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the animation.
 */
@Serializable
data class InlineQueryResultMpeg4Gif(
    /**
     * Type of the result, must be mpeg4Gif
     */
    val type: String = "mpeg4Gif",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid URL for the MP4 file. File size must not exceed 1MB
     */
    val mpeg4Url: String = "",
    /**
     * Optional. Video width
     */
    val mpeg4Width: Int? = null,
    /**
     * Optional. Video height
     */
    val mpeg4Height: Int? = null,
    /**
     * Optional. Video duration
     */
    val mpeg4Duration: Int? = null,
    /**
     * URL of the static thumbnail (jpeg or gif) for the result
     */
    val thumbUrl: String? = null,
    /**
     * Optional. Title for the result
     */
    val title: String? = null,
    /**
     * Optional. Caption of the MPEG-4 file to be sent, 0-1024 characters after entities parsing
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
     * Optional. Content of the message to be sent instead of the video animation
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
