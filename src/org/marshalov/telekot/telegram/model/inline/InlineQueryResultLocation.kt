package org.marshalov.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a location on a map (https://core.telegram.org/bots/api#inlinequeryresultlocation).
 * By default, the location will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the location.
 */
@Serializable
data class InlineQueryResultLocation(
    /**
     * Type of the result, must be location
     */
    val type: String = "location",
    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    val id: String = "",
    /**
     * Location latitude in degrees
     */
    val latitude: Float = 0.0F,
    /**
     * Location longitude in degrees
     */
    val longitude: Float = 0.0F,
    /**
     * Location title
     */
    val title: String = "",
    /**
     * Optional. Period in seconds for which the location can be updated, should be between 60 and 86400.
     */
    val livePeriod: Int? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the location
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
