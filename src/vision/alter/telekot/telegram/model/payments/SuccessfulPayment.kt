package vision.alter.telekot.telegram.model.payments

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object contains basic information about a successful payment (https://core.telegram.org/bots/api#successfulpayment).
 */
@Serializable
data class SuccessfulPayment(
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
    val orderInfo: OrderInfo? = null,
    /**
     * Telegram payment identifier
     */
    val telegramPaymentChargeId: String = "",
    /**
     * Provider payment identifier
     */
    val providerPaymentChargeId: String = ""
) : TelegramObject
