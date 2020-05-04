package org.marshalov.telekot.client.model.payments

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.User
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object contains information about an incoming pre-checkout query (https://core.telegram.org/bots/api#precheckoutquery).
 */
@Serializable
data class PreCheckoutQuery(
    /**
     * Unique query identifier
     */
    val id: String = "",
    /**
     * User who sent the query
     */
    val from: User = User(),
    /**
     * Three-letter ISO 4217 currency code
     */
    val currency: String = "",
    /**
     * Total price in the smallest units of the currency (integer, not float/double).
     * For example, for a price of US$ 1.45 pass amount = 145.
     * See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency
     * (2 for the majority of currencies).
     */
    val totalAmount: Int = 0,
    /**
     * Bot specified invoice payload
     */
    val invoicePayload: String = "",
    /**
     * Optional. Identifier of the shipping option chosen by the user
     */
    val shippingOptionId: String? = null,
    /**
     * Optional. Order info provided by the user
     */
    val orderInfo: OrderInfo? = null
) : TelegramObject
