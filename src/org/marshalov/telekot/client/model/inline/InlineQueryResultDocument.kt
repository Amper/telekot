package org.marshalov.telekot.client.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.InlineKeyboardMarkup
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * Represents a link to a file (https://core.telegram.org/bots/api#inlinequeryresultdocument).
 * By default, this file will be sent by the user with an optional caption.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the file.
 * Currently, only .PDF and .ZIP files can be sent using this method.
 */
@Serializable
data class InlineQueryResultDocument(
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
     * Optional. Caption of the document to be sent, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the document caption. See formatting options for more details.
     */
    val parseMode: String? = null,
    /**
     * A valid URL for the file
     */
    val documentUrl: String? = null,
    /**
     * Mime type of the content of the file, either “application/pdf” or “application/zip”
     */
    val mimeType: String? = null,
    /**
     * Optional. Short description of the result
     */
    val description: String? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the file
     */
    val inputMessageContent: InputMessageContent? = null,
    /**
     * Optional. URL of the thumbnail (jpeg only) for the file
     */
    val thumbUrl: String? = null,
    /**
     * Optional. Thumbnail width
     */
    val thumbWidth: Int? = null,
    /**
     * Optional. Thumbnail height
     */
    val thumbHeight: Int? = null
) : TelegramObject,
    InlineQueryResult
