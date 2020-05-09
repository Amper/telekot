package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.StickersBotApiClient
import org.marshalov.telekot.client.api.impl.StickersBotApiClientImpl
import org.marshalov.telekot.client.factories.ApiClientFactory

/**
 * Factory for creating of Stickers Telegram Bot API Client.
 */
object StickersBotApiClientFactory :
    ApiClientFactory<StickersBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): StickersBotApiClient =
        StickersBotApiClientImpl(apiToken, apiUrl, client)
}
