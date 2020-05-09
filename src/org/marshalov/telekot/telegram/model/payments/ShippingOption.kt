package org.marshalov.telekot.telegram.model.payments

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents one shipping option (https://core.telegram.org/bots/api#shippingoption).
 */
@Serializable
data class ShippingOption(
    /**
     * Shipping option identifier
     */
    val id: String = "",
    /**
     * Option title
     */
    val title: String = "",
    /**
     * List of price portions
     */
    val prices: List<LabeledPrice> = emptyList()
) : TelegramObject
