package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a bot command (https://core.telegram.org/bots/api#botcommand).
 */
@Serializable
data class BotCommand(
    /**
     * Text of the command, 1-32 characters. Can contain only lowercase English letters, digits and underscores.
     */
    val command: String = "",
    /**
     * Description of the command, 3-256 characters.
     */
    val description: String = ""
) : TelegramObject
