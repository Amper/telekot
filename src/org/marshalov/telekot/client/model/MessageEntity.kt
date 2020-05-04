package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents one special entity in a text message (https://core.telegram.org/bots/api#messageentity).
 * For example, hashtags, usernames, URLs, etc.
 */
@Serializable
data class MessageEntity(
    /**
     * Type of the entity.
     * Can be “mention” (@username), “hashtag” (#hashtag), “cashtag” ($USD), “bot_command” (/start@jobs_bot),
     * “url” (https://telegram.org), “email” (do-not-reply@telegram.org), “phone_number” (+1-212-555-0123),
     * “bold” (bold text), “italic” (italic text), “underline” (underlined text), “strikethrough” (strikethrough text),
     * “code” (monowidth string), “pre” (monowidth block), “text_link” (for clickable text URLs),
     * “text_mention” (for users without usernames)
     */
    val type: String = "",
    /**
     * Offset in UTF-16 code units to the start of the entity
     */
    val offset: Int = -1,
    /**
     * Length of the entity in UTF-16 code units
     */
    val length: Int = -1,
    /**
     * Optional. For “text_link” only, url that will be opened after user taps on the text
     */
    val url: String? = null,
    /**
     * Optional. For “text_mention” only, the mentioned user
     */
    val user: User? = null,
    /**
     * Optional. For “pre” only, the programming language of the entity text
     */
    val language: String? = null
) : TelegramObject
