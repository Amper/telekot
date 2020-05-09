package org.marshalov.telekot.telegram.model.games

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.User
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents one row of the high scores table for a game (https://core.telegram.org/bots/api#gamehighscore).
 */
@Serializable
data class GameHighScore(
    /**
     * Position in high score table for the game
     */
    val position: Long = -1,
    /**
     * User
     */
    val user: User = User(),
    /**
     * Score
     */
    val score: Long = -1
) : TelegramObject
