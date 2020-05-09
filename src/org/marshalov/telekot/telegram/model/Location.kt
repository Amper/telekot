package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a point on the map (https://core.telegram.org/bots/api#location).
 */
@Serializable
data class Location(
    /**
     * Longitude as defined by sender
     */
    val longitude: Float = 0.0F,
    /**
     * Latitude as defined by sender
     */
    val latitude: Float = 0.0F
) : TelegramObject
