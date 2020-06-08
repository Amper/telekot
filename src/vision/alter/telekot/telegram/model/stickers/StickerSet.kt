package vision.alter.telekot.telegram.model.stickers

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.PhotoSize
import vision.alter.telekot.telegram.model.markers.TelegramObject

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
