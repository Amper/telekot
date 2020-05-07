package org.marshalov.telekot.client.api.impl

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.ApiClientWrapper
import org.marshalov.telekot.client.api.MessageEditingBotApiClient
import org.marshalov.telekot.client.model.InlineKeyboardMarkup
import org.marshalov.telekot.client.model.InputMedia
import org.marshalov.telekot.client.model.Message
import org.marshalov.telekot.client.model.Poll

/**
 * Updating Messages Mode Telegram Bot API implementation.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 */
class MessageEditingBotApiClientImpl(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) : MessageEditingBotApiClient {

    override suspend fun editMessageText(
        text: String,
        chatId: String?,
        messageId: Long?,
        inlineMessageId: String?,
        parseMode: String?,
        disableWebPagePreview: Boolean?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::editMessageText, mapOf(
                "text" to text,
                "chat_id" to chatId,
                "message_id" to messageId,
                "inline_message_id" to inlineMessageId,
                "parse_mode" to parseMode,
                "disable_web_page_preview" to disableWebPagePreview,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun editMessageCaption(
        chatId: String?,
        messageId: Long?,
        inlineMessageId: String?,
        caption: String?,
        parseMode: String?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::editMessageCaption, mapOf(
                "chat_id" to chatId,
                "message_id" to messageId,
                "inline_message_id" to inlineMessageId,
                "caption" to caption,
                "parse_mode" to parseMode,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun editMessageMedia(
        media: InputMedia,
        chatId: String?,
        messageId: Long?,
        inlineMessageId: String?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::editMessageCaption, mapOf(
                "media" to media,
                "chat_id" to chatId,
                "message_id" to messageId,
                "inline_message_id" to inlineMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun editMessageReplyMarkup(
        chatId: String?,
        messageId: Long?,
        inlineMessageId: String?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::editMessageCaption, mapOf(
                "chat_id" to chatId,
                "message_id" to messageId,
                "inline_message_id" to inlineMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun stopPoll(
        chatId: String,
        messageId: Long,
        replyMarkup: InlineKeyboardMarkup?
    ): Poll =
        api.getMethodResult(
            ::stopPoll, mapOf(
                "chat_id" to chatId,
                "message_id" to messageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun deleteMessage(
        chatId: String,
        messageId: Long
    ): Boolean =
        api.getMethodResult(
            ::deleteMessage, mapOf(
                "chat_id" to chatId,
                "message_id" to messageId
            )
        )

    // ------------------------------------------------------------------------------------------------------------- //

    private val api = ApiClientWrapper(apiToken, apiUrl, client)
}
