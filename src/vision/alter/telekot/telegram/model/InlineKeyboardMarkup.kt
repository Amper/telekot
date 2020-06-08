package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.ReplyMarkup
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * (https://core.telegram.org/bots/api#inlinekeyboardmarkup)
 */
@Serializable
data class InlineKeyboardMarkup(
    /**
     * Array of button rows, each represented by an Array of InlineKeyboardButton objects.
     */
    val inlineKeyboard: List<List<InlineKeyboardButton>> = emptyList()
) : TelegramObject,
    ReplyMarkup
