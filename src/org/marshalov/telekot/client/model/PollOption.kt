package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

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
