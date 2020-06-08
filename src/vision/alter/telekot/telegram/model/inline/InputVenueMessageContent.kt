package vision.alter.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Represents the content of a venue message to be sent as the result of an inline query
 * (https://core.telegram.org/bots/api#inputvenuemessagecontent).
 */
@Serializable
data class InputVenueMessageContent(
    /**
     * Latitude of the venue in degrees
     */
    val latitude: Float = 0.0F,
    /**
     * Longitude of the venue in degrees
     */
    val longitude: Float = 0.0F,
    /**
     * Name of the venue
     */
    val title: String = "",
    /**
     * Address of the venue
     */
    val address: String = "",
    /**
     * Optional. Foursquare identifier of the venue, if known
     */
    val foursquareId: String? = null,
    /**
     * Optional. Foursquare type of the venue, if known.
     * (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
     */
    val foursquareType: String? = null
) : TelegramObject,
    InputMessageContent
