package org.marshalov.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.Location
import org.marshalov.telekot.telegram.model.User
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a result of an inline query that was chosen by the user and sent to their chat partner
 * (https://core.telegram.org/bots/api#choseninlineresult).
 */
@Serializable
data class ChosenInlineResult(
    /**
     * The unique identifier for the result that was chosen
     */
    val resultId: String = "",
    /**
     * The user that chose the result
     */
    val from: User = User(),
    /**
     * Optional. Identifier of the sent inline message.
     * Available only if there is an inline keyboard attached to the message.
     * Will be also received in callback queries and can be used to edit the message.
     */
    val inlineMessageId: String = "",
    /**
     * The query that was used to obtain the result
     */
    val query: String = "",
    /**
     * Optional. Sender location, only for bots that require user location
     */
    val location: Location? = null
) : TelegramObject
