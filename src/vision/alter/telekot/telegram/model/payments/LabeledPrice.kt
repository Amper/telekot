package vision.alter.telekot.telegram.model.payments

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a portion of the price for goods or services.
 * (https://core.telegram.org/bots/api#labeledprice)
 */
@Serializable
data class LabeledPrice(
    /**
     * Portion label
     */
    val label: String = "",
    /**
     * Price of the product in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145.
     * See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency
     * (2 for the majority of currencies).
     */
    val amount: Long = 0
) : TelegramObject
