package vision.alter.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import vision.alter.telekot.client.clients.StickersBotApiClient
import vision.alter.telekot.client.factories.ApiClientFactory
import vision.alter.telekot.telegram.api.StickersBotApi

/**
 * Factory for creating of Stickers Telegram Bot API Client.
 */
object StickersBotApiClientFactory :
    ApiClientFactory<StickersBotApi> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): StickersBotApi =
        StickersBotApiClient(apiToken, apiUrl, client)
}
