package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object contains information about one answer option in a poll (https://core.telegram.org/bots/api#polloption).
 */
@Serializable
data class PollOption(
    /**
     * Option text, 1-100 characters
     */
    val text: String = "",
    /**
     * Number of users that voted for this option
     */
    val voterCount: Int = 0
) : TelegramObject
