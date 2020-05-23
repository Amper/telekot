package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.clients.StickersBotApiClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.telegram.api.StickersBotApi

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
