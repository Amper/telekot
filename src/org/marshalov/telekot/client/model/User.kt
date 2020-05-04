package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents a Telegram user or bot (https://core.telegram.org/bots/api#user).
 */
@Serializable
data class User(
    /**
     * Unique identifier for this user or bot.
     */
    val id: Long = -1,
    /**
     * True, if this user is a bot.
     */
    val isBot: Boolean = false,
    /**
     * User‘s or bot’s first name.
     */
    val firstName: String = "",
    /**
     * Optional. User‘s or bot’s last name.
     */
    val lastName: String? = null,
    /**
     * Optional. User‘s or bot’s username.
     */
    val username: String? = null,
    /**
     * Optional. IETF language tag (https://en.wikipedia.org/wiki/IETF_language_tag) of the user's language.
     */
    val languageCode: String? = null,
    /**
     * Optional. True, if the bot can be invited to groups. Returned only in getMe.
     * @see org.marshalov.telekot.messengers.telegram.client.CommonBotApiClient.getMe
     */
    val canJoinGroups: Boolean? = null,
    /**
     * Optional. True, if privacy mode (https://core.telegram.org/bots#privacy-mode) is disabled for the bot.
     * Returned only in getMe.
     * @see org.marshalov.telekot.messengers.telegram.client.CommonBotApiClient.getMe
     */
    val canReadAllGroupMessages: Boolean? = null,
    /**
     * Optional. True, if the bot supports inline queries. Returned only in getMe.
     * @see org.marshalov.telekot.messengers.telegram.client.CommonBotApiClient.getMe
     */
    val supportsInlineQueries: Boolean? = null
) : TelegramObject
