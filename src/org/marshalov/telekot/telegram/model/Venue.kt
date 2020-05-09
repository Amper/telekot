package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a venue (https://core.telegram.org/bots/api#venue).
 */
@Serializable
data class Venue(
    /**
     * Venue location
     */
    val location: Location = Location(),
    /**
     * Name of the venue
     */
    val title: String = "",
    /**
     * Address of the venue
     */
    val address: String = "",
    /**
     * Optional. Foursquare identifier of the venue
     */
    val foursquareId: String? = null,
    /**
     * Optional. Foursquare type of the venue.
     * (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
     */
    val foursquareType: String? = null
) : TelegramObject
