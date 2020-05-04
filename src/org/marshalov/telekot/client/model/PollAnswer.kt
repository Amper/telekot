package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

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
    val option_ids: List<Int> = emptyList()
) : TelegramObject
