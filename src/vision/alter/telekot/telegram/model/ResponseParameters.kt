package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Contains information about why a request was unsuccessful.
 * (https://core.telegram.org/bots/api#responseparameters)
 */
@Serializable
data class ResponseParameters(
    /**
     * Optional. The group has been migrated to a supergroup with the specified identifier.
     * This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it.
     * But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    val migrateToChatId: Long? = null,
    /**
     * Optional. In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
     */
    val retryAfter: Long? = null
) : TelegramObject
