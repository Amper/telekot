package org.marshalov.telekot.telegram.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Represents a link to a file stored on the Telegram servers.
 * (https://core.telegram.org/bots/api#inlinequeryresultcacheddocument)
 * By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 */
@Serializable
data class InlineQueryResultCachedDocument(
    /**
     * Type of the result, must be document
     */
    val type: String = "document",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * Title for the result
     */
    val title: String = "",
    /**
     * A valid file identifier for the file
     */
    val documentFileId: String = "",
    /**
     * Optional. Short description of the result
     */
    val description: String? = null,
    /**
     * Optional. Caption of the document to be sent, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the document caption. See formatting options for more details.
     */
    val parseMode: String? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the file
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
