package org.marshalov.telekot.telegram.model.payments

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a shipping address (https://core.telegram.org/bots/api#shippingaddress).
 */
@Serializable
data class ShippingAddress(
    /**
     * ISO 3166-1 alpha-2 country code
     */
    val countryCode: String = "",
    /**
     * State, if applicable
     */
    val state: String = "",
    /**
     * City
     */
    val city: String = "",
    /**
     * First line for the address
     */
    val streetLine1: String = "",
    /**
     * Second line for the address
     */
    val streetLine2: String = "",
    /**
     * Address post code
     */
    val postCode: String = ""
) : TelegramObject
