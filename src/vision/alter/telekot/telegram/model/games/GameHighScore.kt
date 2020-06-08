package vision.alter.telekot.telegram.model.games

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.User
import vision.alter.telekot.telegram.model.markers.TelegramObject

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
