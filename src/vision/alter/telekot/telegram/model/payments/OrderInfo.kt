package vision.alter.telekot.telegram.model.payments

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents information about an order (https://core.telegram.org/bots/api#orderinfo).
 */
@Serializable
data class OrderInfo(
    /**
     * Optional. User name
     */
    val name: String? = null,
    /**
     * Optional. User's phone number
     */
    val phoneNumber: String? = null,
    /**
     * Optional. User email
     */
    val email: String? = null,
    /**
     * Optional. User shipping address
     */
    val shippingAddress: ShippingAddress? = null
) : TelegramObject
