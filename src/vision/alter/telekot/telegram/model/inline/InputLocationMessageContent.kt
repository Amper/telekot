package vision.alter.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Represents the content of a location message to be sent as the result of an inline query
 * (https://core.telegram.org/bots/api#inputlocationmessagecontent).
 */
@Serializable
data class InputLocationMessageContent(
    /**
     * Latitude of the location in degrees
     */
    val latitude: Float = 0.0F,
    /**
     * Longitude of the location in degrees
     */
    val longitude: Float = 0.0F,
    /**
     * Optional. Period in seconds for which the location can be updated, should be between 60 and 86400.
     */
    val livePeriod: Int? = null
) : TelegramObject,
    InputMessageContent
