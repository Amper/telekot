package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents an answer of a user in a non-anonymous poll (https://core.telegram.org/bots/api#pollanswer).
 */
@Serializable
data class PollAnswer(
    /**
     * Unique poll identifier
     */
    val pollId: String = "",
    /**
     * The user, who changed the answer to the poll
     */
    val user: User = User(),
    /**
     * 0-based identifiers of answer options, chosen by the user. May be empty if the user retracted their vote.
     */
    val optionIds: List<Int> = emptyList()
) : TelegramObject
