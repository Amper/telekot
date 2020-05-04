package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents a general file (as opposed to photos, voice messages and audio files) (https://core.telegram.org/bots/api#document).
 */
@Serializable
data class Document(
    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    val fileId: String = "",
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    val fileUniqueId: String = "",
    /**
     * Optional. Document thumbnail as defined by sender
     */
    val thumb: PhotoSize? = null,
    /**
     * Optional. Original filename as defined by sender
     */
    val fileName: String? = null,
    /**
     * Optional. MIME type of the file as defined by sender
     */
    val mimeType: String? = null,
    /**
     * Optional. File size
     */
    val fileSize: Int? = null
) : TelegramObject
