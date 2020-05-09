package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.InputMediaPhotoOrVideo
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a video to be sent (https://core.telegram.org/bots/api#inputmediavideo).
 */
@Serializable
data class InputMediaVideo(
    /**
     * Type of the result, must be video
     */
    val type: String = "video",
    /**
     * File to send.
     * Pass a fileId to send a file that exists on the Telegram servers (recommended),
     * pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<fileAttachName>”
     * to upload a new one using multipart/form-data under <fileAttachName> name.
     */
    val media: String = "",
    /**
     * Optional. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. T
     * he thumbnail should be in JPEG format and less than 200 kB in size.
     * A thumbnail‘s width and height should not exceed 320.
     * Ignored if the file is not uploaded using multipart/form-data.
     * Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<fileAttachName>”
     * if the thumbnail was uploaded using multipart/form-data under <fileAttachName>.
     */
    // @TODO: Add binary file for uploading by multipart/form-data
    val thumb: String? = null,
    /**
     * Optional. Caption of the video to be sent, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the video caption. See formatting options for more details.
     */
    // @TODO: enum
    val parseMode: String? = null,
    /**
     * Optional. Video width
     */
    val width: Int? = null,
    /**
     * Optional. Video height
     */
    val height: Int? = null,
    /**
     * Optional. Video duration
     */
    val duration: Int? = null,
    /**
     * Optional. Pass True, if the uploaded video is suitable for streaming
     */
    val supportsStreaming: Boolean? = null
) : TelegramObject,
    InputMedia,
    InputMediaPhotoOrVideo
