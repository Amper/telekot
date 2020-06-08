package vision.alter.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.InlineKeyboardMarkup
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a link to a voice message stored on the Telegram servers.
 * (https://core.telegram.org/bots/api#inlinequeryresultcachedvoice)
 * By default, this voice message will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the voice message.
 */
@Serializable
data class InlineQueryResultCachedVoice(
    /**
     * Type of the result, must be voice
     */
    val type: String = "voice",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid file identifier for the voice message
     */
    val voiceFileId: String = "",
    /**
     * Voice message title
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
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the voice message
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
