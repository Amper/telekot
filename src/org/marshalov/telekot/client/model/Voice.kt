package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents a voice note (https://core.telegram.org/bots/api#voice).
 */
@Serializable
data class Voice(
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
     * Optional. MIME type of the file as defined by sender
     */
    val mimeType: String? = null,
    /**
     * Optional. File size
     */
    val fileSize: Int? = null
) : TelegramObject
