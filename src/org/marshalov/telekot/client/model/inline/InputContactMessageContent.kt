package org.marshalov.telekot.client.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * Represents the content of a contact message to be sent as the result of an inline query
 * (https://core.telegram.org/bots/api#inputcontactmessagecontent).
 */
@Serializable
data class InputContactMessageContent(
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
     * Optional. Additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    val vcard: String? = null
) : TelegramObject,
    InputMessageContent
