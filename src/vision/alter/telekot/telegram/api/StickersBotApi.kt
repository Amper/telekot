package vision.alter.telekot.telegram.api

import vision.alter.telekot.telegram.model.File
import vision.alter.telekot.telegram.model.InlineKeyboardMarkup
import vision.alter.telekot.telegram.model.Message
import vision.alter.telekot.telegram.model.stickers.MaskPosition
import vision.alter.telekot.telegram.model.stickers.StickerSet

/**
 * Interface for Inline Telegram Bot API (https://core.telegram.org/bots/api#inline-mode).
 */
interface StickersBotApi : TelegramApi {
    /**
     * Use this method to send static .WEBP or animated .TGS stickers (https://core.telegram.org/bots/api#sendsticker).
     * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * @param sticker Sticker to send. Pass a fileId as String to send a file that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get a .WEBP file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup ReplyMarkup Additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     * @return sent Message.
     */
    suspend fun sendSticker(
        chatId: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        sticker: String,
        disableNotification: Boolean? = null,
        replyToMessageId: Long? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * Use this method to get a sticker set (https://core.telegram.org/bots/api#getstickerset).
     * @param name Name of the sticker set
     * @return a StickerSet object.
     */
    suspend fun getStickerSet(
        name: String
    ): StickerSet

    /**
     * Use this method to upload a .PNG file with a sticker for later use in createNewStickerSet and addStickerToSet
     * methods (can be used multiple times) (https://core.telegram.org/bots/api#uploadstickerfile).
     * @param userId User identifier of sticker file owner
     * @param pngSticker PNG image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px.
     * @return the uploaded File.
     */
    suspend fun uploadStickerFile(
        userId: Long,
        // @TODO: Add binary file for uploading by multipart/form-data
        pngSticker: String
    ): File

    /**
     * Use this method to create a new sticker set owned by a user.
     * (https://core.telegram.org/bots/api#createnewstickerset)
     * The bot will be able to edit the sticker set thus created.
     * You must use exactly one of the fields png_sticker or tgs_sticker.
     * @param userId User identifier of created sticker set owner
     * @param name Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only english letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in “By<bot username>”. <botUsername> is case insensitive. 1-64 characters.
     * @param title Sticker set title, 1-64 characters
     * @param emojis One or more emoji corresponding to the sticker
     * @param pngSticker PNG image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a fileId as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
     * @param tgsSticker TGS animation with the sticker, uploaded using multipart/form-data. See https://core.telegram.org/animatedStickers#technical-requirements for technical requirements
     * @param containsMasks Pass True, if a set of mask stickers should be created
     * @param maskPosition A JSON-serialized object for position where the mask should be placed on faces
     * @return True on success.
     */
    suspend fun createNewStickerSet(
        userId: Long,
        name: String,
        title: String,
        emojis: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        pngSticker: String? = null,
        // @TODO: Add binary file for uploading by multipart/form-data
        tgsSticker: String? = null,
        containsMasks: Boolean? = null,
        maskPosition: MaskPosition? = null
    ): Boolean

    /**
     * Use this method to add a new sticker to a set created by the bot.
     * (https://core.telegram.org/bots/api#addstickertoset)
     * You must use exactly one of the fields png_sticker or tgs_sticker.
     * Animated stickers can be added to animated sticker sets and only to them.
     * Animated sticker sets can have up to 50 stickers.
     * Static sticker sets can have up to 120 stickers.
     * @param userId User identifier of sticker set owner
     * @param name Sticker set name
     * @param emojis One or more emoji corresponding to the sticker
     * @param pngSticker PNG image with the sticker, must be up to 512 kilobytes in size, dimensions must not exceed 512px, and either width or height must be exactly 512px. Pass a fileId as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. More info on Sending Files »
     * @param tgsSticker TGS animation with the sticker, uploaded using multipart/form-data. See https://core.telegram.org/animatedStickers#technical-requirements for technical requirements
     * @param maskPosition A JSON-serialized object for position where the mask should be placed on faces
     * @return True on success.
     */
    suspend fun addStickerToSet(
        userId: Long,
        name: String,
        emojis: String,
        // @TODO: Add binary file for uploading by multipart/form-data
        pngSticker: String? = null,
        // @TODO: Add binary file for uploading by multipart/form-data
        tgsSticker: String? = null,
        maskPosition: MaskPosition? = null
    ): Boolean

    /**
     * Use this method to move a sticker in a set created by the bot to a specific position.
     * (https://core.telegram.org/bots/api#setstickerpositioninset)
     * @param sticker File identifier of the sticker
     * @param position New sticker position in the set, zero-based
     * @return True on success.
     */
    suspend fun setStickerPositionInSet(
        sticker: String,
        position: Int
    ): Boolean

    /**
     * Use this method to delete a sticker from a set created by the bot.
     * (https://core.telegram.org/bots/api#deletestickerfromset)
     * @param sticker File identifier of the sticker
     * @return True on success.
     */
    suspend fun deleteStickerFromSet(
        sticker: String
    ): Boolean

    /**
     * Use this method to set the thumbnail of a sticker set.
     * (https://core.telegram.org/bots/api#setstickersetthumb)
     * Animated thumbnails can be set for animated sticker sets only.
     * @param name Sticker set name
     * @param userId User identifier of the sticker set owner
     * @param thumb A PNG image with the thumbnail, must be up to 128 kilobytes in size and have width and height exactly 100px, or a TGS animation with the thumbnail up to 32 kilobytes in size; see https://core.telegram.org/animated_stickers#technical-requirements for animated sticker technical requirements. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. Animated sticker set thumbnail can't be uploaded via HTTP URL.
     * @return True on success.
     */
    suspend fun setStickerSetThumb(
        name: String,
        userId: Long,
        thumb: String? = null
    ): Boolean
}
