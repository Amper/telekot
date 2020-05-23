package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.ReplyMarkup
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Upon receiving a message with this object, Telegram clients will remove the current custom keyboard
 * and display the default letter-keyboard.
 * (https://core.telegram.org/bots/api#replykeyboardremove)
 * By default, custom keyboards are displayed until a new keyboard is sent by a bot.
 * An exception is made for one-time keyboards that are hidden immediately
 * after the user presses a button (see ReplyKeyboardMarkup).
 */
@Serializable
data class ReplyKeyboardRemove(
    /**
     * Requests clients to remove the custom keyboard (user will not be able to summon this keyboard;
     * if you want to hide the keyboard from sight but keep it accessible, use one_time_keyboard in ReplyKeyboardMarkup)
     */
    val removeKeyboard: Boolean = true,
    /**
     * Optional. Use this parameter if you want to remove the keyboard for specific users only.
     * Targets:
     *  1) users that are @mentioned in the text of the Message object;
     *  2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     * Example: A user votes in a poll, bot returns confirmation message in reply to the vote
     * and removes the keyboard for that user, while still showing the keyboard with poll options
     * to users who haven't voted yet.
     */
    val selective: Boolean? = null
) : TelegramObject,
    ReplyMarkup