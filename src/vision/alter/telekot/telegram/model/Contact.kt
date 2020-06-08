package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a phone contact (https://core.telegram.org/bots/api#contact).
 */
@Serializable
data class Contact(
    /**
     * Contact's phone number
     */
    val phoneNumber: String = "",
    /**
     * Contact's first name
     */
    val firstName: String = "",
    /**
     * Optional. Contact's last name
     */
    val lastName: String? = null,
    /**
     * Optional. Contact's user identifier in Telegram
     */
    val userId: Long? = null,
    /**
     * Optional. Additional data about the contact in the form of a vCard
     */
    val vcard: String? = null
) : TelegramObject
