package vision.alter.telekot.telegram.model.stickers

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object describes the position on faces where a mask should be placed by default (https://core.telegram.org/bots/api#maskposition).
 */
@Serializable
data class MaskPosition(
    /**
     * The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
     */
    val point: String = "",
    /**
     * number	Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
     */
    val xShift: Float = 0.0F,
    /**
     * number	Shift by Y-axis measured in heights of the mask scaled to the face size, from top to telekotom. For example, 1.0 will place the mask just below the default mask position.
     */
    val yShift: Float = 0.0F,
    /**
     * number	Mask scaling coefficient. For example, 2.0 mea
     */
    val scale: Float = 0.0F
) : TelegramObject
