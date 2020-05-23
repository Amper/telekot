package org.marshalov.telekot.telegram.api

import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.InputMedia
import org.marshalov.telekot.telegram.model.Message
import org.marshalov.telekot.telegram.model.Poll

/**
 * Interface for Updating Messages Telegram Bot API (https://core.telegram.org/bots/api#updating-messages).
 */
interface MessageEditingBotApi : TelegramApi {
    /**
     * Use this method to edit text and game messages (https://core.telegram.org/bots/api#editmessagetext).
     * @param chatId Required if inlineMessageId is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Required if inlineMessageId is not specified. Identifier of the message to edit
     * @param inlineMessageId Required if chatId and messageId are not specified. Identifier of the inline message
     * @param text New text of the message, 1-4096 characters after entities parsing
     * @param parseMode Mode for parsing entities in the message text. See formatting options for more details.
     * @param disableWebPagePreview Disables link previews for links in this message
     * @param replyMarkup A JSON-serialized object for an inline keyboard.
     * @return edited Message
     */
    suspend fun editMessageText(
        text: String,
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        parseMode: String? = null,
        disableWebPagePreview: Boolean? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * Use this method to edit captions of messages (https://core.telegram.org/bots/api#editmessagecaption).
     * @param chatId Required if inlineMessageId is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Required if inlineMessageId is not specified. Identifier of the message to edit
     * @param inlineMessageId Required if chatId and messageId are not specified. Identifier of the inline message
     * @param caption New caption of the message, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the message caption. See formatting options for more details.
     * @param replyMarkup A JSON-serialized object for an inline keyboard.
     * @return edited Message
     */
    suspend fun editMessageCaption(
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        caption: String? = null,
        parseMode: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * Use this method to edit animation, audio, document, photo, or video messages.
     * (https://core.telegram.org/bots/api#editmessagemedia)
     * If a message is a part of a message album, then it can be edited only to a photo or a video.
     * Otherwise, message type can be changed arbitrarily.
     * When inline message is edited, new file can't be uploaded.
     * Use previously uploaded file via its file_id or specify a URL.
     * @param chatId Required if inlineMessageId is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Required if inlineMessageId is not specified. Identifier of the message to edit
     * @param inlineMessageId Required if chatId and messageId are not specified. Identifier of the inline message
     * @param media A JSON-serialized object for a new media content of the message
     * @param replyMarkup A JSON-serialized object for a new inline keyboard.
     * @return edited Message
     */
    suspend fun editMessageMedia(
        media: InputMedia,
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * Use this method to edit only the reply markup of messages.
     * (https://core.telegram.org/bots/api#editmessagereplymarkup)
     * @param chatId Required if inlineMessageId is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Required if inlineMessageId is not specified. Identifier of the message to edit
     * @param inlineMessageId Required if chatId and messageId are not specified. Identifier of the inline message
     * @param replyMarkup A JSON-serialized object for an inline keyboard.
     * @return edited Message
     */
    suspend fun editMessageReplyMarkup(
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * Use this method to stop a poll which was sent by the bot (https://core.telegram.org/bots/api#stoppoll).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of the original message with the poll
     * @param replyMarkup A JSON-serialized object for a new message inline keyboard.
     * @return edited Message
     */
    suspend fun stopPoll(
        chatId: String,
        messageId: Long,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Poll

    /**
     * Use this method to delete a message, including service messages, with the following limitations:
     *  - A message can only be deleted if it was sent less than 48 hours ago.
     *  - A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.
     *  - Bots can delete outgoing messages in private chats, groups, and supergroups.
     *  - Bots can delete incoming messages in private chats.
     *  - Bots granted can_post_messages permissions can delete outgoing messages in channels.
     *  - If the bot is an administrator of a group, it can delete any message there.
     *  - If the bot has can_delete_messages permission in a supergroup or a channel, it can delete any message there.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of the message to delete
     * @return True on success
     */
    suspend fun deleteMessage(
        chatId: String,
        messageId: Long
    ): Boolean
}
