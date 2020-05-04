package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents an audio file to be treated as music by the Telegram clients (https://core.telegram.org/bots/api#audio).
 */
@Serializable
data class Audio(
    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    val fileId: String = "",
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    val fileUniqueId: String = "",
    /**
     * Duration of the audio in seconds as defined by sender
     */
    val duration: Int = -1,
    /**
     * Optional. Performer of the audio as defined by sender or by audio tags
     */
    val performer: String? = null,
    /**
     * Optional. Title of the audio as defined by sender or by audio tags
     */
    val title: String? = null,
    /**
     * Optional. MIME type of the file as defined by sender
     */
    val mimeType: String? = null,
    /**
     * Optional. File size
     */
    val fileSize: Int? = null,
    /**
     * Optional. Thumbnail of the album cover to which the music file belongs
     */
    val thumb: PhotoSize? = null
) : TelegramObject
