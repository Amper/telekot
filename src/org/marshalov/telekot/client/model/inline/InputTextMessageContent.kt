package org.marshalov.telekot.client.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * Represents the content of a text message to be sent as the result of an inline query
 * (https://core.telegram.org/bots/api#inputtextmessagecontent).
 */
@Serializable
data class InputTextMessageContent(
    /**
     * Text of the message to be sent, 1-4096 characters
     */
    val messageText: String = "",
    /**
     * Optional. Mode for parsing entities in the message text. See formatting options for more details.
     */
    val parseMode: String? = null,
    /**
     * Optional. Disables link previews for links in the sent message
     */
    val disableWebPagePreview: Boolean? = null
) : TelegramObject,
    InputMessageContent
