package org.marshalov.telekot.client.model.inline

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.InlineKeyboardMarkup
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * Represents a link to an article or web page (https://core.telegram.org/bots/api#inlinequeryresultarticle).
 */
@Serializable
data class InlineQueryResultArticle(
    /**
     * Type of the result, must be article
     */
    val type: String = "article",
    /**
     * Unique identifier for this result, 1-64 Bytes
     */
    val id: String = "",
    /**
     * Title of the result
     */
    val title: String = "",
    /**
     * Content of the message to be sent
     */
    val inputMessageContent: InputMessageContent? = null,
    /**
     * Optional. Inline keyboard attached to the message
     */
    val replyMarkup: InlineKeyboardMarkup? = null,
    /**
     * Optional. URL of the result
     */
    val url: String? = null,
    /**
     * Optional. Pass True, if you don't want the URL to be shown in the message
     */
    val hideUrl: Boolean? = null,
    /**
     * Optional. Short description of the result
     */
    val description: String? = null,
    /**
     * Optional. Url of the thumbnail for the result
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
