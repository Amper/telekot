package vision.alter.telekot.telegram.model.payments

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.User
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object contains information about an incoming shipping query (https://core.telegram.org/bots/api#shippingquery).
 */
@Serializable
data class ShippingQuery(
    /**
     * Unique query identifier
     */
    val id: String = "",
    /**
     * User who sent the query
     */
    val from: User = User(),
    /**
     * Bot specified invoice payload
     */
    val invoicePayload: String = "",
    /**
     * User specified shipping address
     */
    val shippingAddress: ShippingAddress = ShippingAddress()
) : TelegramObject
