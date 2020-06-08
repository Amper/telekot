package vision.alter.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.InlineKeyboardMarkup
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a venue (https://core.telegram.org/bots/api#inlinequeryresultvenue).
 * By default, the venue will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the venue.
 */
@Serializable
data class InlineQueryResultVenue(
    /**
     * Type of the result, must be venue
     */
    val type: String = "venue",
    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    val id: String = "",
    /**
     * Latitude of the venue location in degrees
     */
    val latitude: Float = 0.0F,
    /**
     * Longitude of the venue location in degrees
     */
    val longitude: Float = 0.0F,
    /**
     * Title of the venue
     */
    val title: String = "",
    /**
     * Address of the venue
     */
    val address: String = "",
    /**
     * Optional. Foursquare identifier of the venue if known
     */
    val foursquareId: String? = null,
    /**
     * Optional. Foursquare type of the venue, if known.
     * (For example, “artsEntertainment/default”, “artsEntertainment/aquarium” or “food/icecream”.)
     */
    val foursquareType: String? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the venue
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
