package org.marshalov.telekot.telegram.api

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
 * Interface for Common Telegram Bot API (https://core.telegram.org/bots/api#available-methods).
 */
@Suppress("ComplexInterface", "TooManyFunctions", "LongParameterList")
interface CommonBotApi : TelegramApi {
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
        replyToMessageId: Long? = null,
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
        messageId: Long,
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
        replyToMessageId: Long? = null,
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
        replyToMessageId: Long? = null,
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
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send video files, Telegram clients support mp4 videos (other formats may be sent as Document).
     * (https://core.telegram.org/bots/api#sendvideo)
     * Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param video Video to send. Pass a fileId as String to send a video that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a video from the Internet, or upload a new video using multipart/form-data. More info on Sending Files »
     * @param duration Duration of sent video in seconds
     * @param width Video width
     * @param height Video height
     * @param thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<fileAttachName>” if the thumbnail was uploaded using multipart/form-data under <fileAttachName>. More info on Sending Files »
     * @param caption Video caption (may also be used when resending videos by fileId), 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the video caption. See formatting options for more details.
     * @param supportsStreaming Pass True, if the uploaded video is suitable for streaming
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return sent Message
     */
    suspend fun sendVideo(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        video: String,
        duration: Int? = null,
        width: Int? = null,
        height: Int? = null,
        // @TODO: Add binary file for uploading by multipart/form-data
        thumb: String? = null,
        caption: String? = null,
        // @TODO: enum
        parseMode: String? = null,
        supportsStreaming: Boolean? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound).
     * (https://core.telegram.org/bots/api#sendanimation)
     * Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param animation Animation to send. Pass a fileId as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data. More info on Sending Files »
     * @param duration Duration of sent animation in seconds
     * @param width Animation width
     * @param height Animation height
     * @param thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<fileAttachName>” if the thumbnail was uploaded using multipart/form-data under <fileAttachName>. More info on Sending Files »
     * @param caption Animation caption (may also be used when resending animation by fileId), 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the animation caption. See formatting options for more details.
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply
     * @return sent Message
     */
    suspend fun sendAnimation(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        animation: String,
        duration: Int? = null,
        width: Int? = null,
        height: Int? = null,
        // @TODO: Add binary file for uploading by multipart/form-data
        thumb: String? = null,
        caption: String? = null,
        // @TODO: enum
        parseMode: String? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message.
     * For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as Audio or Document).
     * (https://core.telegram.org/bots/api#sendvoice)
     * Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param voice Audio file to send. Pass a fileId as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
     * @param caption Voice message caption, 0-1024 characters after entities parsing
     * @param parseMode Mode for parsing entities in the voice message caption. See formatting options for more details.
     * @param duration Duration of the voice message in seconds
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return sent Message
     */
    suspend fun sendVoice(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        voice: String,
        caption: String? = null,
        // @TODO: enum
        parseMode: String? = null,
        duration: Int? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * As of v.4.0, Telegram clients support rounded square mp4 videos of up to 1 minute long.
     * Use this method to send video messages (https://core.telegram.org/bots/api#sendvideonote).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param videoNote Video note to send. Pass a fileId as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data. More info on Sending Files ». Sending video notes by a URL is currently unsupported
     * @param duration Duration of sent video in seconds
     * @param length Video width and height, i.e. diameter of the video message
     * @param thumb Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<fileAttachName>” if the thumbnail was uploaded using multipart/form-data under <fileAttachName>. More info on Sending Files »
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a re
     * @return sent Message
     */
    suspend fun sendVideoNote(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        videoNote: String,
        duration: Int? = null,
        length: Int? = null,
        // @TODO: Add binary file for uploading by multipart/form-data
        thumb: String? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send a group of photos or videos as an album (https://core.telegram.org/bots/api#sendmediagroup).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param media A JSON-serialized array describing photos and videos to be sent, must include 2-10 items
     * @param disableNotification Sends the messages silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the messages are a reply, ID of the original message
     * @return a list of the sent Messages
     */
    suspend fun sendMediaGroup(
        chatId: String,
        media: List<InputMediaPhotoOrVideo>,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null
    ): List<Message>

    /**
     * Use this method to send point on the map (https://core.telegram.org/bots/api#sendlocation).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude Latitude of the location
     * @param longitude Longitude of the location
     * @param livePeriod Period in seconds for which the location will be updated (see Live Locations, should be between 60 and 86400.
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return sent Message
     */
    suspend fun sendLocation(
        chatId: String,
        latitude: Float,
        longitude: Float,
        livePeriod: Int? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to edit live location messages (https://core.telegram.org/bots/api#editmessagelivelocation).
     * A location can be edited until its live_period expires or editing is explicitly disabled by a call to stopMessageLiveLocation.
     * @param latitude Latitude of new location
     * @param longitude Longitude of new location
     * @param chatId Required if inlineMessageId is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Required if inlineMessageId is not specified. Identifier of the message to edit
     * @param inlineMessageId Required if chatId and messageId are not specified. Identifier of the inline message
     * @param replyMarkup A JSON-serialized object for a new inline keyboard.
     * @return the edited Message
     */
    suspend fun editMessageLiveLocation(
        latitude: Float,
        longitude: Float,
        chatId: String? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * Use this method to stop updating a live location message before live_period expires
     * (https://core.telegram.org/bots/api#stopmessagelivelocation).
     * @param chatId Required if inlineMessageId is not specified. Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Required if inlineMessageId is not specified. Identifier of the message with live location to stop
     * @param inlineMessageId Required if chatId and messageId are not specified. Identifier of the inline message
     * @param replyMarkup A JSON-serialized object for a new inline keyboard.
     * @return the sent Message
     */
    suspend fun stopMessageLiveLocation(
        chatId: Long? = null,
        messageId: Long? = null,
        inlineMessageId: String? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * Use this method to send information about a venue (https://core.telegram.org/bots/api#sendvenue).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param latitude Latitude of the venue
     * @param longitude Longitude of the venue
     * @param title Name of the venue
     * @param address Address of the venue
     * @param foursquareId Foursquare identifier of the venue
     * @param foursquareType Foursquare type of the venue, if known. (For example, “artsEntertainment/default”, “artsEntertainment/aquarium” or “food/icecream”.)
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return send Message
     */
    suspend fun sendVenue(
        chatId: String,
        latitude: Float,
        longitude: Float,
        title: String,
        address: String,
        foursquareId: String? = null,
        foursquareType: String? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send phone contacts (https://core.telegram.org/bots/api#sendcontact).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param phoneNumber Contact's phone number
     * @param firstName Contact's first name
     * @param lastName Contact's last name
     * @param vcard Additional data about the contact in the form of a vCard, 0-2048 bytes
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove keyboard or to force a reply from the user.
     * @return send Message
     */
    suspend fun sendContact(
        chatId: String,
        phoneNumber: String,
        firstName: String,
        lastName: String? = null,
        vcard: String? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send a native poll (https://core.telegram.org/bots/api#sendpoll).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param question Poll question, 1-255 characters
     * @param options A JSON-serialized list of answer options, 2-10 strings 1-100 characters each
     * @param isAnonymous True, if the poll needs to be anonymous, defaults to True
     * @param type Poll type, “quiz” or “regular”, defaults to “regular”
     * @param allowsMultipleAnswers True, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to False
     * @param correctOptionId 0-based identifier of the correct answer option, required for polls in quiz mode
     * @param explanation Text that is shown when a user chooses an incorrect answer or taps on the lamp icon in a quiz-style poll, 0-200 characters with at most 2 line feeds after entities parsing
     * @param explanationParseMode Mode for parsing entities in the explanation. See formatting options for more details.
     * @param openPeriod Amount of time in seconds the poll will be active after creation, 5-600. Can't be used together with closeDate.
     * @param closeDate Point in time (Unix timestamp) when the poll will be automatically closed. Must be at least 5 and no more than 600 seconds in the future. Can't be used together with openPeriod.
     * @param isClosed Pass True, if the poll needs to be immediately closed. This can be useful for poll preview.
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return send Message
     */
    suspend fun sendPoll(
        chatId: String,
        question: String,
        options: List<String>,
        isAnonymous: Boolean? = null,
        type: String? = null,
        allowsMultipleAnswers: Boolean? = null,
        correctOptionId: Long? = null,
        explanation: String? = null,
        explanationParseMode: String? = null,
        openPeriod: Int? = null,
        closeDate: Int? = null,
        isClosed: Boolean? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: ReplyMarkup? = null
    ): Message

    /**
     * Use this method to send a dice, which will have a random value from 1 to 6.
     * (https://core.telegram.org/bots/api#senddice)
     * (Yes, we're aware of the “proper” singular of die.
     * But it's awkward, and we decided to help it change. One dice at a time!)
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param emoji Emoji on which the dice throw animation is based. Currently, must be one of “🎲” or “🎯”. Defauts to “🎲”
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return send Message
     */
    suspend fun sendDice(
        chatId: String,
        emoji: String? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
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
     * Use this method to get a list of profile pictures for a user.
     * (https://core.telegram.org/bots/api#getuserprofilephotos)
     * @param userId Unique identifier of the target user
     * @param offset Sequential number of the first photo to be returned. By default, all photos are returned.
     * @param limit Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     * @return a UserProfilePhotos object
     */
    suspend fun getUserProfilePhotos(
        userId: Long,
        offset: Int? = null,
        limit: Int? = null
    ): UserProfilePhotos

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
     * Use this method to kick a user from a group, a supergroup or a channel.
     * (https://core.telegram.org/bots/api#kickchatmember)
     * In the case of supergroups and channels, the user will not be able to return to the group
     * on their own using invite links, etc., unless unbanned first.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     * @param untilDate Date when the user will be unbanned, unix time. If user is banned for more than 366 days or less than 30 seconds from the current time they are considered to be banned forever
     * @return True on success
     */
    suspend fun kickChatMember(
        chatId: String,
        userId: Long,
        untilDate: Int? = null
    ): Boolean

    /**
     * Use this method to unban a previously kicked user in a supergroup or channel.
     * (https://core.telegram.org/bots/api#unbanchatmember)
     * The user will not return to the group or channel automatically, but will be able to join via link, etc.
     * The bot must be an administrator for this to work.
     * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     * @return True on success
     */
    suspend fun unbanChatMember(
        chatId: String,
        userId: Long
    ): Boolean

    /**
     * Use this method to restrict a user in a supergroup.
     * (https://core.telegram.org/bots/api#restrictchatmember)
     * The bot must be an administrator in the supergroup for this to work and must have the appropriate admin rights.
     * Pass True for all permissions to lift restrictions from a user.
     * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     * @param permissions New user permissions
     * @param untilDate Date when restrictions will be lifted for the user, unix time. If user is restricted for more than 366 days or less than 30 seconds from the current time, they are considered to be restricted forever
     * @return True on success.
     */
    suspend fun restrictChatMember(
        chatId: String,
        userId: Long,
        permissions: ChatPermissions,
        untilDate: Int? = null
    ): Boolean

    /**
     * Use this method to promote or demote a user in a supergroup or a channel.
     * (https://core.telegram.org/bots/api#promotechatmember)
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Pass False for all boolean parameters to demote a user.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     * @param canChangeInfo Pass True, if the administrator can change chat title, photo and other settings
     * @param canPostMessages Pass True, if the administrator can create channel posts, channels only
     * @param canEditMessages Pass True, if the administrator can edit messages of other users and can pin messages, channels only
     * @param canDeleteMessages Pass True, if the administrator can delete messages of other users
     * @param canInviteUsers Pass True, if the administrator can invite new users to the chat
     * @param canRestrictMembers Pass True, if the administrator can restrict, ban or unban chat members
     * @param canPinMessages Pass True, if the administrator can pin messages, supergroups only
     * @param canPromoteMembers Pass True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by him)
     * @return True on success.
     */
    suspend fun promoteChatMember(
        chatId: String,
        userId: Long,
        canChangeInfo: Boolean? = null,
        canPostMessages: Boolean? = null,
        canEditMessages: Boolean? = null,
        canDeleteMessages: Boolean? = null,
        canInviteUsers: Boolean? = null,
        canRestrictMembers: Boolean? = null,
        canPinMessages: Boolean? = null,
        canPromoteMembers: Boolean? = null
    ): Boolean

    /**
     * Use this method to set a custom title for an administrator in a supergroup promoted by the bot.
     * (https://core.telegram.org/bots/api#setchatadministratorcustomtitle)
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param userId Unique identifier of the target user
     * @param customTitle New custom title for the administrator; 0-16 characters, emoji are not allowed
     * @return True on success.
     */
    suspend fun setChatAdministratorCustomTitle(
        chatId: String,
        userId: Long,
        customTitle: String
    ): Boolean

    /**
     * Use this method to set default chat permissions for all members.
     * (https://core.telegram.org/bots/api#setchatpermissions)
     * he bot must be an administrator in the group or a supergroup for this to work
     * and must have the can_restrict_members admin rights.
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param permissions New default chat permissions
     * @return True on success.
     */
    suspend fun setChatPermissions(
        chatId: String,
        permissions: ChatPermissions
    ): Boolean

    /**
     * Use this method to generate a new invite link for a chat; any previously generated link is revoked.
     * (https://core.telegram.org/bots/api#exportchatinvitelink)
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Note: Each administrator in a chat generates their own invite links.
     * Bots can't use invite links generated by other administrators.
     * If you want your bot to work with invite links, it will need to generate its own link
     * using exportChatInviteLink — after this the link will become available to the bot via the getChat method.
     * If your bot needs to generate a new invite link replacing its previous one, use exportChatInviteLink again.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @return the new invite link as String on success.
     */
    suspend fun exportChatInviteLink(
        chatId: String
    ): String

    /**
     * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats.
     * (https://core.telegram.org/bots/api#setchatphoto)
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param photo New chat photo, uploaded using multipart/form-data
     * @return True on success.
     */
    suspend fun setChatPhoto(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        photo: String
    ): Boolean

    /**
     * Use this method to delete a chat photo (https://core.telegram.org/bots/api#deletechatphoto).
     * Photos can't be changed for private chats.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @return True on success.
     */
    suspend fun deleteChatPhoto(
        chatId: String
    ): Boolean

    /**
     * Use this method to change the title of a chat (https://core.telegram.org/bots/api#setchattitle).
     * Titles can't be changed for private chats.
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param title New chat title, 1-255 characters
     * @return True on success.
     */
    suspend fun setChatTitle(
        chatId: String,
        title: String
    ): Boolean

    /**
     * Use this method to change the description of a group, a supergroup or a channel.
     * (https://core.telegram.org/bots/api#setchatdescription)
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param description New chat description, 0-255 characters
     * @return True on success.
     */
    suspend fun setChatDescription(
        chatId: String,
        description: String
    ): Boolean

    /**
     * Use this method to pin a message in a group, a supergroup, or a channel.
     * (https://core.telegram.org/bots/api#pinchatmessage)
     * The bot must be an administrator in the chat for this to work and must have
     * the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param messageId Identifier of a message to pin
     * @param disableNotification Pass True, if it is not necessary to send a notification to all chat members about the new pinned message. Notifications are always disabled in channels.
     * @return True on success.
     */
    suspend fun pinChatMessage(
        chatId: String,
        messageId: Long,
        disableNotification: Boolean? = null
    ): Boolean

    /**
     * Use this method to unpin a message in a group, a supergroup, or a channel.
     * (https://core.telegram.org/bots/api#unpinchatmessage)
     * The bot must be an administrator in the chat for this to work and must have
     * the ‘can_pin_messages’ admin right in the supergroup or ‘can_edit_messages’ admin right in the channel.
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @return True on success.
     */
    suspend fun unpinChatMessage(
        chatId: String
    ): Boolean

    /**
     * Use this method for your bot to leave a group, supergroup or channel (https://core.telegram.org/bots/api#leavechat).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @return True on success.
     */
    suspend fun leaveChat(
        chatId: String
    ): Boolean

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
     * Use this method to get a list of administrators in a chat (https://core.telegram.org/bots/api#getchatadministrators).
     * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channelusername)
     * @return an Array of ChatMember objects that contains information about all chat administrators except other bots.
     *  If the chat is a group or a supergroup and no administrators were appointed, only the creator will be returned.
     */
    suspend fun getChatAdministrators(
        chatId: String
    ): List<ChatMember>

    /**
     * Use this method to get the number of members in a chat (https://core.telegram.org/bots/api#getchatmemberscount).
     * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channelusername)
     * @return Int on success.
     */
    suspend fun getChatMembersCount(
        chatId: String
    ): Int

    /**
     * Use this method to get information about a member of a chat (https://core.telegram.org/bots/api#getchatmember).
     * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channelusername)
     * @param userId Unique identifier of the target user
     * @return a ChatMember object on success.
     */
    suspend fun getChatMember(
        chatId: String,
        userId: Long
    ): ChatMember

    /**
     * Use this method to set a new group sticker set for a supergroup (https://core.telegram.org/bots/api#setchatstickerset).
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Use the field can_set_sticker_set optionally returned in getChat requests to check if the bot can use this method.
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @param stickerSetName Name of the sticker set to be set as the group sticker set
     * @return True on success.
     */
    suspend fun setChatStickerSet(
        chatId: String,
        stickerSetName: String
    ): Boolean

    /**
     * Use this method to delete a group sticker set from a supergroup (https://core.telegram.org/bots/api#deletechatstickerset).
     * The bot must be an administrator in the chat for this to work and must have the appropriate admin rights.
     * Use the field can_set_sticker_set optionally returned in getChat requests to check if the bot can use this method.
     * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroupusername)
     * @return True on success.
     */
    suspend fun deleteChatStickerSet(
        chatId: String
    ): Boolean

    /**
     * Use this method to send answers to callback queries sent from inline keyboards.
     * (https://core.telegram.org/bots/api#answercallbackquery)
     * The answer will be displayed to the user as a notification at the top of the chat screen or as an alert.
     * @param callbackQueryId Unique identifier for the query to be answered
     * @param text Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters
     * @param showAlert If true, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to false.
     * @param url URL that will be opened by the user's client. If you have created a Game and accepted the conditions via @Botfather, specify the URL that opens your game — note that this will only work if the query comes from a callback_game button. Otherwise, you may use links like t.me/your_bot?start=XXXX that open your bot with a parameter.
     * @param cacheTime The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
     * @return True on success.
     */
    suspend fun answerCallbackQuery(
        callbackQueryId: String,
        text: String? = null,
        showAlert: Boolean? = null,
        url: String? = null,
        cacheTime: Int? = null
    ): Boolean

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
