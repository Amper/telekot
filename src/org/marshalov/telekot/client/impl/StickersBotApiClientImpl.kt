package org.marshalov.telekot.client.impl

import io.ktor.client.HttpClient
import org.marshalov.telekot.telegram.api.StickersBotApiClient
import org.marshalov.telekot.telegram.model.File
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.Message
import org.marshalov.telekot.telegram.model.stickers.MaskPosition
import org.marshalov.telekot.telegram.model.stickers.StickerSet

/**
 * Stickers Telegram Bot API implementation.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 */
class StickersBotApiClientImpl(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) : StickersBotApiClient {

    override suspend fun sendSticker(
        chatId: String,
        sticker: String,
        disableNotification: Boolean?,
        replyToMessageId: Long?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::sendSticker, mapOf(
                "chat_id" to chatId,
                "sticker" to sticker,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun getStickerSet(
        name: String
    ): StickerSet =
        api.getMethodResult(
            ::getStickerSet, mapOf(
                "name" to name
            )
        )

    override suspend fun uploadStickerFile(
        userId: Long,
        pngSticker: String
    ): File =
        api.getMethodResult(
            ::uploadStickerFile, mapOf(
                "user_id" to userId,
                "png_sticker" to pngSticker
            )
        )

    override suspend fun createNewStickerSet(
        userId: Long,
        name: String,
        title: String,
        emojis: String,
        pngSticker: String?,
        tgsSticker: String?,
        containsMasks: Boolean?,
        maskPosition: MaskPosition?
    ): Boolean =
        api.getMethodResult(
            ::createNewStickerSet, mapOf(
                "user_id" to userId,
                "name" to name,
                "title" to title,
                "emojis" to emojis,
                "png_sticker" to pngSticker,
                "tgs_sticker" to tgsSticker,
                "contains_masks" to containsMasks,
                "mask_position" to maskPosition
            )
        )

    override suspend fun addStickerToSet(
        userId: Long,
        name: String,
        emojis: String,
        pngSticker: String?,
        tgsSticker: String?,
        maskPosition: MaskPosition?
    ): Boolean =
        api.getMethodResult(
            ::addStickerToSet, mapOf(
                "user_id" to userId,
                "name" to name,
                "emojis" to emojis,
                "png_sticker" to pngSticker,
                "tgs_sticker" to tgsSticker,
                "mask_position" to maskPosition
            )
        )

    override suspend fun setStickerPositionInSet(
        sticker: String,
        position: Int
    ): Boolean =
        api.getMethodResult(
            ::setStickerPositionInSet, mapOf(
                "sticker" to sticker,
                "position" to position
            )
        )

    override suspend fun deleteStickerFromSet(
        sticker: String
    ): Boolean =
        api.getMethodResult(
            ::deleteStickerFromSet, mapOf(
                "sticker" to sticker
            )
        )

    override suspend fun setStickerSetThumb(
        name: String,
        userId: Long,
        thumb: String?
    ): Boolean =
        api.getMethodResult(
            ::setStickerSetThumb, mapOf(
                "name" to name,
                "userId" to userId,
                "thumb" to thumb
            )
        )

    // ------------------------------------------------------------------------------------------------------------- //

    private val api = ApiClientWrapper(apiToken, apiUrl, client)
}
