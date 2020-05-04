package org.marshalov.telekot.client.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.InlineKeyboardMarkup
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * Represents a link to a sticker stored on the Telegram servers.
 * (https://core.telegram.org/bots/api#inlinequeryresultcachedsticker)
 * By default, this sticker will be sent by the user.
 * Alternatively, you can use input_message_content to send a message with the specified content instead of the sticker.
 */
@Serializable
data class InlineQueryResultCachedSticker(
    /**
     * Type of the result, must be sticker
     */
    val type: String = "sticker",
    /**
     * Unique identifier for this result, 1-64 bytes
     */
    val id: String = "",
    /**
     * A valid file identifier of the sticker
     */
    val stickerFileId: String = "",
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. Content of the message to be sent instead of the sticker
     */
    val inputMessageContent: InputMessageContent? = null
) : TelegramObject,
    InlineQueryResult
