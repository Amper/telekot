package org.marshalov.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a link to a voice recording in an .OGG container encoded with OPUS.
 * (https://core.telegram.org/bots/api#inlinequeryresultvoice)
 * By default, this voice recording will be sent by the user.
 * Alternatively, you can use input_message_content to send a message
 * with the specified content instead of the the voice message.
 */
@Serializable
data class InlineQueryResultVoice(
    /**
     * Type of the result, must be voice
     */
    val type: String = "voice",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid URL for the voice recording
     */
    val voiceUrl: String = "",
    /**
     * Recording title
     */
    val title: String = "",
    /**
     * Optional. Caption, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the voice message caption. See formatting options for more details.
     */
    val parseMode: String? = null,
    /**
     * Optional. Recording duration in seconds
     */
    val voiceDuration: Int? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the voice recording
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
