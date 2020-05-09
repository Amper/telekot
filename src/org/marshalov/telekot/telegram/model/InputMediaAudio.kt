package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents an audio file to be treated as music to be sent (https://core.telegram.org/bots/api#inputmediaaudio).
 */
@Serializable
data class InputMediaAudio(
    /**
     * Type of the result, must be audio
     */
    val type: String = "audio",
    /**
     * File to send.
     * Pass a fileId to send a file that exists on the Telegram servers (recommended),
     * pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<fileAttachName>”
     * to upload a new one using multipart/form-data under <fileAttachName> name.
     */
    val media: String = "",
    /**
     * Optional. Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side.
     * The thumbnail should be in JPEG format and less than 200 kB in size.
     * A thumbnail‘s width and height should not exceed 320.
     * Ignored if the file is not uploaded using multipart/form-data.
     * Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<fileAttachName>”
     * if the thumbnail was uploaded using multipart/form-data under <fileAttachName>.
     */
    // @TODO: Add binary file for uploading by multipart/form-data
    val thumb: String? = null,
    /**
     * Optional. Caption of the audio to be sent, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the audio caption. See formatting options for more details.
     */
    // @TODO: enum
    val parseMode: String? = null,
    /**
     * Optional. Duration of the audio in seconds
     */
    val duration: Int? = null,
    /**
     * Optional. Performer of the audio
     */
    val performer: String? = null,
    /**
     * Optional. Title of the audio
     */
    val title: String? = null
) : TelegramObject,
    InputMedia
