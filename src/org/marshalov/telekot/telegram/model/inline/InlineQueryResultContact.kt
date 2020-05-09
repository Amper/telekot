package org.marshalov.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a contact with a phone number (https://core.telegram.org/bots/api#inlinequeryresultcontact).
 * By default, this contact will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the contact.
 */
@Serializable
data class InlineQueryResultContact(
    /**
     * Type of the result, must be contact
     */
    val type: String = "contact",
    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    val id: String = "",
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
    val vcard: String? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the contact
     */
    val inputMessageContent: InputMessageContent? = null,
    /**
     * Optional. Url of the thumbnail for the result
     */
    val thumbUrl: String? = null,
    /**
     * Optional. Thumbnail width
     */
    val thumbWidth: Int? = null,
    /**
     * Optional. Thumbnail height
     */
    val thumbHeight: Int? = null
) : TelegramObject,
    InlineQueryResult
