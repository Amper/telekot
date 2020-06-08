package vision.alter.telekot.telegram.model.payments

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object contains basic information about an invoice (https://core.telegram.org/bots/api#invoice).
 */
@Serializable
data class Invoice(
    /**
     * Product name
     */
    val title: String = "",
    /**
     * Product description
     */
    val description: String = "",
    /**
     * Unique bot deep-linking parameter that can be used to generate this invoice
     */
    val startParameter: String = "",
    /**
     * Three-letter ISO 4217 currency code
     */
    val currency: String = "",
    /**
     * Total price in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145.
     * See the exp parameter in currencies.json,
     * it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
     */
    val totalAmount: Int = -1
) : TelegramObject
