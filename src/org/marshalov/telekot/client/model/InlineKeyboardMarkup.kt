package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.ReplyMarkup
import org.marshalov.telekot.client.model.markers.TelegramObject

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
