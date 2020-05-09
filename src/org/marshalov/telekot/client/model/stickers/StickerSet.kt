package org.marshalov.telekot.client.model.stickers

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.PhotoSize
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents a sticker set (https://core.telegram.org/bots/api#stickerset).
 */
@Serializable
data class StickerSet(
    /**
     * Sticker set name
     */
    val name: String = "",
    /**
     * Sticker set title
     */
    val title: String = "",
    /**
     * True, if the sticker set contains animated stickers
     */
    val isAnimated: Boolean = false,
    /**
     * True, if the sticker set contains masks
     */
    val containsMasks: Boolean = false,
    /**
     * List of all set stickers
     */
    val stickers: List<Sticker> = emptyList(),
    /**
     * Optional. Sticker set thumbnail in the .WEBP or .TGS format
     */
    val thumb: PhotoSize? = null
) : TelegramObject
