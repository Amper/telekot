package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents one size of a photo or a file / sticker thumbnail (https://core.telegram.org/bots/api#photosize).
 */
@Serializable
data class PhotoSize(
    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    val fileId: String = "",
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    val fileUniqueId: String = "",
    /**
     * Photo width
     */
    val width: Int = -1,
    /**
     * Photo height
     */
    val height: Int = -1,
    /**
     * Optional. File size
     */
    val fileSize: Int? = null
) : TelegramObject
