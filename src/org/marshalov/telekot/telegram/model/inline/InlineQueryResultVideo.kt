package org.marshalov.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a link to a page containing an embedded video player or a video file.
 * (https://core.telegram.org/bots/api#inlinequeryresultvideo)
 * By default, this video file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the video.
 * If an InlineQueryResultVideo message contains an embedded video (e.g., YouTube),
 * you must replace its content using inputMessageContent.
 */
@Serializable
data class InlineQueryResultVideo(
    /**
     * Type of the result, must be video
     */
    val type: String = "video",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid URL for the embedded video player or video file
     */
    val videoUrl: String = "",
    /**
     * Mime type of the content of video url, “text/html” or “video/mp4”
     */
    val mimeType: String = "",
    /**
     * URL of the thumbnail (jpeg only) for the video
     */
    val thumbUrl: String = "",
    /**
     * Title for the result
     */
    val title: String = "",
    /**
     * Optional. Caption of the video to be sent, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the video caption. See formatting options for more details.
     */
    val parseMode: String? = null,
    /**
     * Optional. Video width
     */
    val videoWidth: Int? = null,
    /**
     * Optional. Video height
     */
    val videoHeight: Int? = null,
    /**
     * Optional. Video duration in seconds
     */
    val videoDuration: Int? = null,
    /**
     * Optional. Short description of the result
     */
    val description: String? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the video.
     * This field is required if InlineQueryResultVideo is used to send an HTML-page as a result (e.g., a YouTube video).
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
