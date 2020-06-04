package org.marshalov.telekot.server.testing.controllers

import org.marshalov.telekot.telegram.api.CommonBotApi
import org.marshalov.telekot.telegram.model.BotCommand
import org.marshalov.telekot.telegram.model.Chat
import org.marshalov.telekot.telegram.model.ChatMember
import org.marshalov.telekot.telegram.model.ChatPermissions
import org.marshalov.telekot.telegram.model.File
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.Message
import org.marshalov.telekot.telegram.model.User
import org.marshalov.telekot.telegram.model.UserProfilePhotos
import org.marshalov.telekot.telegram.model.markers.InputMediaPhotoOrVideo
import org.marshalov.telekot.telegram.model.markers.ReplyMarkup

/**
 *
 */
@SuppressWarnings("TooManyFunctions", "StringLiteralDuplication")
class TestCommonBotApiController : CommonBotApi, AbstractTestBotApiController() {

    override suspend fun getMe(): User =
        manager.getBotInfo(token)

    override suspend fun sendMessage(
        chatId: String,
        text: String,
        parseMode: String?,
        disableWebPagePreview: Boolean?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun forwardMessage(
        chatId: String,
        fromChatId: String,
        messageId: Long,
        disableNotification: Boolean?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendPhoto(
        chatId: String,
        photo: String,
        caption: String?,
        parseMode: String?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

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
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendDocument(
        chatId: String,
        document: String,
        thumb: String?,
        caption: String?,
        parseMode: String?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

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
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

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
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendVoice(
        chatId: String,
        voice: String,
        caption: String?,
        parseMode: String?,
        duration: Int?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendVideoNote(
        chatId: String,
        videoNote: String,
        duration: Int?,
        length: Int?,
        thumb: String?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendMediaGroup(
        chatId: String,
        media: List<InputMediaPhotoOrVideo>,
        disableNotification: Boolean?,
        replyToMessageId: Long?
    ): List<Message> {
        TODO("Not yet implemented")
    }

    override suspend fun sendLocation(
        chatId: String,
        latitude: Float,
        longitude: Float,
        livePeriod: Int?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun editMessageLiveLocation(
        latitude: Float,
        longitude: Float,
        chatId: String?,
        messageId: Long?,
        inlineMessageId: String?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun stopMessageLiveLocation(
        chatId: Long?,
        messageId: Long?,
        inlineMessageId: String?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendVenue(
        chatId: String,
        latitude: Float,
        longitude: Float,
        title: String,
        address: String,
        foursquareId: String?,
        foursquareType: String?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendContact(
        chatId: String,
        phoneNumber: String,
        firstName: String,
        lastName: String?,
        vcard: String?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendPoll(
        chatId: String,
        question: String,
        options: List<String>,
        isAnonymous: Boolean?,
        type: String?,
        allowsMultipleAnswers: Boolean?,
        correctOptionId: Long?,
        explanation: String?,
        explanationParseMode: String?,
        openPeriod: Int?,
        closeDate: Int?,
        isClosed: Boolean?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendDice(
        chatId: String,
        emoji: String?,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: ReplyMarkup?
    ): Message {
        TODO("Not yet implemented")
    }

    override suspend fun sendChatAction(chatId: String, action: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getUserProfilePhotos(userId: Long, offset: Int?, limit: Int?): UserProfilePhotos {
        TODO("Not yet implemented")
    }

    override suspend fun getFile(fileId: String): File {
        TODO("Not yet implemented")
    }

    override suspend fun kickChatMember(chatId: String, userId: Long, untilDate: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun unbanChatMember(chatId: String, userId: Long): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun restrictChatMember(
        chatId: String,
        userId: Long,
        permissions: ChatPermissions,
        untilDate: Int?
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun promoteChatMember(
        chatId: String,
        userId: Long,
        canChangeInfo: Boolean?,
        canPostMessages: Boolean?,
        canEditMessages: Boolean?,
        canDeleteMessages: Boolean?,
        canInviteUsers: Boolean?,
        canRestrictMembers: Boolean?,
        canPinMessages: Boolean?,
        canPromoteMembers: Boolean?
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun setChatAdministratorCustomTitle(chatId: String, userId: Long, customTitle: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun setChatPermissions(chatId: String, permissions: ChatPermissions): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun exportChatInviteLink(chatId: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun setChatPhoto(chatId: String, photo: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteChatPhoto(chatId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun setChatTitle(chatId: String, title: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun setChatDescription(chatId: String, description: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun pinChatMessage(chatId: String, messageId: Long, disableNotification: Boolean?): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun unpinChatMessage(chatId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun leaveChat(chatId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getChat(chatId: String): Chat {
        TODO("Not yet implemented")
    }

    override suspend fun getChatAdministrators(chatId: String): List<ChatMember> {
        TODO("Not yet implemented")
    }

    override suspend fun getChatMembersCount(chatId: String): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getChatMember(chatId: String, userId: Long): ChatMember {
        TODO("Not yet implemented")
    }

    override suspend fun setChatStickerSet(chatId: String, stickerSetName: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteChatStickerSet(chatId: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun answerCallbackQuery(
        callbackQueryId: String,
        text: String?,
        showAlert: Boolean?,
        url: String?,
        cacheTime: Int?
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun setMyCommands(
        commands: List<BotCommand>
    ): Boolean {
        val oldBotInfo = manager.getBotInfo(token)
        val newBotInfo = manager.changeBotInfo(
            username = oldBotInfo.username ?: throw RuntimeException("TODO"),
            commands = commands
        )
        return true
    }

    override suspend fun getMyCommands(): List<BotCommand> =
        manager.getBotCommands(token)
}
