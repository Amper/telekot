package org.marshalov.telekot.client.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.InlineKeyboardMarkup
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * Represents a link to an MP3 audio file (https://core.telegram.org/bots/api#inlinequeryresultaudio).
 * By default, this audio file will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the audio.
 */
@Serializable
data class InlineQueryResultAudio(
    /**
     * Type of the result, must be audio
     */
    val type: String = "audio",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid URL for the audio file
     */
    val audioUrl: String = "",
    /**
     * Title
     */
    val title: String = "",
    /**
     * Optional. Caption, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the audio caption. See formatting options for more details.
     */
    val parseMode: String? = null,
    /**
     * Optional. Performer
     */
    val performer: String? = null,
    /**
     * Optional. Audio duration in seconds
     */
    val audioDuration: Int? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the audio
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
