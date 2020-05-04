package org.marshalov.telekot.client.model.stickers

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.PhotoSize
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents a sticker (https://core.telegram.org/bots/api#sticker).
 */
@Serializable
data class Sticker(
    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    val fileId: String = "",
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    val fileUniqueId: String = "",
    /**
     * Sticker width
     */
    val width: Int = -1,
    /**
     * Sticker height
     */
    val height: Int = -1,
    /**
     * True, if the sticker is animated
     */
    val isAnimated: Boolean = false,
    /**
     * Optional. Sticker thumbnail in the .WEBP or .JPG format
     */
    val thumb: PhotoSize? = null,
    /**
     * Optional. Emoji associated with the sticker
     */
    val emoji: String? = null,
    /**
     * Optional. Name of the sticker set to which the sticker belongs
     */
    val setName: String? = null,
    /**
     * Optional. For mask stickers, the position where the mask should be placed
     */
    val maskPosition: MaskPosition? = null,
    /**
     * Optional. File size
     */
    val fileSize: Int? = null
) : TelegramObject
