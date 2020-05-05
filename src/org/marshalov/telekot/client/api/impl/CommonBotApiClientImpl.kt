package org.marshalov.telekot.client.api.impl

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.ApiClientWrapper
import org.marshalov.telekot.client.api.CommonBotApiClient
import org.marshalov.telekot.client.model.BotCommand
import org.marshalov.telekot.client.model.Chat
import org.marshalov.telekot.client.model.File
import org.marshalov.telekot.client.model.InlineKeyboardMarkup
import org.marshalov.telekot.client.model.Message
import org.marshalov.telekot.client.model.User
import org.marshalov.telekot.client.model.markers.InputMediaPhotoOrVideo
import org.marshalov.telekot.client.model.markers.ReplyMarkup

/**
 * Common Telegram Bot API implementation.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 */
@Suppress("StringLiteralDuplication", "TooManyFunctions")
class CommonBotApiClientImpl(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) : CommonBotApiClient {

    override suspend fun getMe(): User =
        api.getMethodResult(this::getMe)

    override suspend fun sendMessage(
        chatId: String,
        text: String,
        parseMode: String?,
        disableWebPagePreview: Boolean?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendMessage, mapOf(
                "chat_id" to chatId,
                "text" to text,
                "parse_mode" to parseMode,
                "disable_web_page_preview" to disableWebPagePreview,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun forwardMessage(
        chatId: String,
        fromChatId: String,
        messageId: Int,
        disableNotification: Boolean?
    ): Message =
        api.getMethodResult(
            ::forwardMessage, mapOf(
                "chat_id" to chatId,
                "from_chat_id" to fromChatId,
                "message_id" to messageId,
                "disable_notification" to disableNotification
            )
        )

    override suspend fun sendPhoto(
        chatId: String,
        photo: String,
        caption: String?,
        parseMode: String?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendPhoto, mapOf(
                "chat_id" to chatId,
                "photo" to photo,
                "caption" to caption,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendAudio(
        chatId: String,
        audio: String,
        caption: String?,
        parseMode: String?,
        duration: Int?,
        performer: String?,
        title: String?,
        thumb: String?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendAudio, mapOf(
                "chat_id" to chatId,
                "audio" to audio,
                "caption" to caption,
                "parse_mode" to parseMode,
                "duraion" to duration,
                "performer" to performer,
                "title" to title,
                "thumb" to thumb,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendDocument(
        chatId: String,
        document: String,
        thumb: String?,
        caption: String?,
        parseMode: String?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendDocument, mapOf(
                "chat_id" to chatId,
                "document" to document,
                "thumb" to thumb,
                "caption" to caption,
                "parse_mode" to parseMode,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendVideo(
        chatId: String,
        video: String,
        duration: Int?,
        width: Int?,
        height: Int?,
        thumb: String?,
        caption: String?,
        parseMode: String?,
        supportsStreaming: Boolean?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendVideo, mapOf(
                "chat_id" to chatId,
                "video" to video,
                "duration" to duration,
                "width" to width,
                "height" to height,
                "thumb" to thumb,
                "caption" to caption,
                "parse_mode" to parseMode,
                "supports_streaming" to supportsStreaming,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendAnimation(
        chatId: String,
        animation: String,
        duration: Int?,
        width: Int?,
        height: Int?,
        thumb: String?,
        caption: String?,
        parseMode: String?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendAnimation, mapOf(
                "chat_id" to chatId,
                "animation" to animation,
                "duration" to duration,
                "width" to width,
                "height" to height,
                "thumb" to thumb,
                "caption" to caption,
                "parse_mode" to parseMode,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendVoice(
        chatId: String,
        voice: String,
        caption: String?,
        parseMode: String?,
        duration: Int?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendVoice, mapOf(
                "chat_id" to chatId,
                "voice" to voice,
                "caption" to caption,
                "parse_mode" to parseMode,
                "duration" to duration,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendVideoNote(
        chatId: String,
        videoNote: String,
        duration: Int?,
        length: Int?,
        thumb: String?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendVideoNote, mapOf(
                "chat_id" to chatId,
                "video_note" to videoNote,
                "duration" to duration,
                "length" to length,
                "thumb" to thumb,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendMediaGroup(
        chatId: String,
        media: List<InputMediaPhotoOrVideo>,
        disableNotification: Boolean?,
        replyToMessageId: Int?
    ): List<Message> =
        api.getMethodResult(
            ::sendMediaGroup, mapOf(
                "chat_id" to chatId,
                "media" to media,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId
            )
        )

    override suspend fun sendLocation(
        chatId: String,
        latitude: Float,
        longitude: Float,
        livePeriod: Int?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendLocation, mapOf(
                "chat_id" to chatId,
                "latitude" to latitude,
                "longitude" to longitude,
                "live_period" to livePeriod,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun editMessageLiveLocation(
        latitude: Float,
        longitude: Float,
        chatId: String?,
        messageId: Int?,
        inlineMessageId: String?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::editMessageLiveLocation, mapOf(
                "latitude" to latitude,
                "longitude" to longitude,
                "chat_id" to chatId,
                "message_id" to messageId,
                "inline_message_id" to inlineMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun stopMessageLiveLocation(
        chatId: Int?,
        messageId: Int?,
        inlineMessageId: String?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::stopMessageLiveLocation, mapOf(
                "chat_id" to chatId,
                "message_id" to messageId,
                "inline_message_id" to inlineMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendVenue(
        chatId: String,
        latitude: Float,
        longitude: Float,
        title: String,
        address: String,
        foursquareId: String?,
        foursquareType: String?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendVenue, mapOf(
                "chat_id" to chatId,
                "latitude" to latitude,
                "longitude" to longitude,
                "title" to title,
                "address" to address,
                "foursquare_id" to foursquareId,
                "foursquare_type" to foursquareType,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendContact(
        chatId: String,
        phoneNumber: String,
        firstName: String,
        lastName: String?,
        vcard: String?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: ReplyMarkup?
    ): Message =
        api.getMethodResult(
            ::sendContact, mapOf(
                "chat_id" to chatId,
                "phone_number" to phoneNumber,
                "first_name" to firstName,
                "last_name" to lastName,
                "vcard" to vcard,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun sendChatAction(chatId: String, action: String): Boolean =
        api.getMethodResult(::sendChatAction, mapOf("chat_id" to chatId, "action" to action))

    override suspend fun getFile(fileId: String): File =
        api.getMethodResult(::getFile, mapOf("file_id" to fileId))

    override suspend fun getChat(chatId: String): Chat =
        api.getMethodResult(::getChat, mapOf("chat_id" to chatId))

    override suspend fun setMyCommands(commands: List<BotCommand>): Boolean =
        api.getMethodResult(::setMyCommands, mapOf("commands" to commands))

    override suspend fun getMyCommands(): List<BotCommand> =
        api.getMethodResult(::getMyCommands)

    // ------------------------------------------------------------------------------------------------------------- //

    private val api = ApiClientWrapper(apiToken, apiUrl, client)
}
