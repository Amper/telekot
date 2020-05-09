package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object contains information about a poll (https://core.telegram.org/bots/api#poll).
 */
@Serializable
data class Poll(
    /**
     * Unique poll identifier
     */
    val id: String = "",
    /**
     * Poll question, 1-255 characters
     */
    val question: String = "",
    /**
     * List of poll options
     */
    val options: List<PollOption> = emptyList(),
    /**
     * Total number of users that voted in the poll
     */
    val totalVoterCount: Int = -1,
    /**
     * True, if the poll is closed
     */
    val isClosed: Boolean = false,
    /**
     * True, if the poll is anonymous
     */
    val isAnonymous: Boolean = false,
    /**
     * Poll type, currently can be “regular” or “quiz”
     */
    val type: String = "",
    /**
     * True, if the poll allows multiple answers
     */
    val allowsMultipleAnswers: Boolean = false,
    /**
     * Optional. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
     */
    val correctOptionId: Int? = null,
    /**
     * Optional. Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters
     */
    val explanation: String? = null,
    /**
     * Optional. Special entities like usernames, URLs, bot commands, etc. that appear in the explanation
     */
    val explanationEntities: List<MessageEntity>? = null,
    /**
     * Optional. Amount of time in seconds the poll will be active after creation
     */
    val openPeriod: Int? = null,
    /**
     * Optional. Point in time (Unix timestamp) when the poll will be automatically closed
     */
    val closeDate: Int? = null
) : TelegramObject
