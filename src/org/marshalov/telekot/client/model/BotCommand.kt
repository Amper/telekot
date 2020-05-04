package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

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
