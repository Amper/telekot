package org.marshalov.telekot.client.api

import org.marshalov.telekot.client.model.BotCommand
import org.marshalov.telekot.client.model.Chat
import org.marshalov.telekot.client.model.File
import org.marshalov.telekot.client.model.Message
import org.marshalov.telekot.client.model.User
import org.marshalov.telekot.client.model.markers.ReplyMarkup

/**
 * Interface for Common Telegram Bot API (https://core.telegram.org/bots/api#available-methods).
 */
interface CommonBotApiClient {
    /**
     * A simple method for testing your bot's auth token. Requires no parameters.
     * @return basic information about the bot in form of a User object.
     */
    suspend fun getMe(): User

    /**
     * Use this method to send text messages. On success, the sent Message is returned.
     * (https://core.telegram.org/bots/api#sendmessage)
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param text Text of the message to be sent, 1-4096 characters after entities parsing
     * @param parseMode Mode for parsing entities in the message text. See formatting options for more details.
     * @param disableWebPagePreview Disables link previews for links in this message
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard.
     * @return sent Message.
     */
    suspend fun sendMessage(
        chatId: String,
        text: String,
        // @TODO: enum
        parseMode: String? = null,
        disableWebPagePreview: Boolean? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Int? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to forward messages of any kind. On success, the sent Message is returned.
     * (https://core.telegram.org/bots/api#forwardmessage)
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername)
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param messageId Message identifier in the chat specified in from_chat_id.
     * @return the sent Message
     */
    suspend fun forwardMessage(
        chatId: String,
        fromChatId: String,
        messageId: Int,
        disableNotification: Boolean? = null
    ): Message

    /**
     * Use this method to send photos. On success, the sent Message is returned (https://core.telegram.org/bots/api#sendphoto).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a photo from the Internet, or upload a new photo using multipart/form-data.
     * @param caption Photo caption (may also be used when resending photos by file_id), 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the photo caption. See formatting options for more details.
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return sent Message
     */
    suspend fun sendPhoto(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        photo: String,
        caption: String? = null,
        // @TODO: enum
        parseMode: String? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Int? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send audio files, if you want Telegram clients to display them in the music player.
     * Your audio must be in the .MP3 or .M4A format. On success, the sent Message is returned.
     * Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
     * For sending voice messages, use the sendVoice method instead.
     * (https://core.telegram.org/bots/api#sendaudio)
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param audio Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an audio file from the Internet, or upload a new one using multipart/form-data.
     * @param caption Audio caption, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the audio caption. See formatting options for more details.
     * @param duration Duration of the audio in seconds
     * @param performer Performer
     * @param title Track name
     * @param thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return sent Message
     */
    @Suppress("LongParameterList")
    suspend fun sendAudio(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        audio: String,
        caption: String? = null,
        // @TODO: enum
        parseMode: String? = null,
        duration: Int? = null,
        performer: String? = null,
        title: String? = null,
        // @TODO: Add binary file for uploading by multipart/form-data
        thumb: String? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Int? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send general files. On success, the sent Message is returned.
     * Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
     * (https://core.telegram.org/bots/api#senddocument)
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param document File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data.
     * @param thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
     * @param caption Document caption (may also be used when resending documents by file_id), 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the audio caption. See formatting options for more details.
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return sent Message
     */
    suspend fun sendDocument(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        document: String,
        thumb: String? = null,
        caption: String? = null,
        // @TODO: enum
        parseMode: String? = null,
        // @TODO: Add binary file for uploading by multipart/form-data
        disableNotification: Boolean? = null,
        replyToMessageId: Int? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method when you need to tell the user that something is happening on the bot's side.
     * The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status).
     * We only recommend using this method when a response from the bot will take a noticeable amount of time to arrive.
     * (https://core.telegram.org/bots/api#sendchataction)
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param action Type of action to broadcast. Choose one, depending on what the user is about to receive:
     *   - typing for text messages,
     *   - upload_photo for photos,
     *   - record_video or upload_video for videos,
     *   - record_audio or upload_audio for audio files,
     *   - upload_document for general files,
     *   - find_location for location data,
     *   - record_video_note or upload_video_note for video notes.
     * @return True on success.
     */
    suspend fun sendChatAction(
        chatId: String,
        // @TODO: enum
        action: String
    ): Boolean

    /**
     * Use this method to get basic info about a file and prepare it for downloading.
     * For the moment, bots can download files of up to 20MB in size. On success, a File object is returned.
     * The file can then be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>,
     * where <file_path> is taken from the response.
     * It is guaranteed that the link will be valid for at least 1 hour.
     * When the link expires, a new one can be requested by calling getFile again.
     * @param fileId File identifier to get info about
     * @return File object
     */
    suspend fun getFile(
        fileId: String
    ): File

    /**
     * Use this method to get up to date information about the chat
     * (current name of the user for one-on-one conversations,
     * current username of a user, group or channel, etc.). Returns a Chat object on success.
     * (https://core.telegram.org/bots/api#getchat)
     * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channelusername)
     * @return Chat object
     */
    suspend fun getChat(
        chatId: String
    ): Chat

    /**
     * Use this method to change the list of the bot's commands (https://core.telegram.org/bots/api#setmycommands).
     * @param commands A JSON-serialized list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
     * @return True on success.
     */
    suspend fun setMyCommands(
        commands: List<BotCommand>
    ): Boolean

    /**
     * Use this method to get the current list of the bot's commands. Requires no parameters.
     * (https://core.telegram.org/bots/api#getmycommands)
     * @returns List of BotCommand on success.
     */
    suspend fun getMyCommands(): List<BotCommand>
}
