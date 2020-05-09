package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard (https://core.telegram.org/bots/api#callbackquery).
 * If the button that originated the query was attached to a message sent by the bot, the field message will be present.
 * If the button was attached to a message sent via the bot (in inline mode), the field inline_message_id will be present.
 * Exactly one of the fields data or game_short_name will be present.
 */
@Serializable
data class CallbackQuery(
    /**
     * Unique identifier for this query
     */
    val id: String = "",
    /**
     * Sender
     */
    val from: User = User(),
    /**
     * Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent.
     * Useful for high scores in games.
     */
    val chatInstance: String = "",
    /**
     * Optional. Message with the callback button that originated the query.
     * Note that message content and message date will not be available if the message is too old
     */
    val message: Message? = null,
    /**
     * Optional. Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    val inlineMessageId: String? = null,
    /**
     * Optional. Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
     */
    val data: String? = null,
    /**
     * Optional. Short name of a Game to be returned, serves as the unique identifier for the game
     */
    val gameShortName: String? = null
) : TelegramObject
