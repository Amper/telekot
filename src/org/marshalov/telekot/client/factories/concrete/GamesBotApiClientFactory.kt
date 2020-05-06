package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.GamesBotApiClient
import org.marshalov.telekot.client.api.impl.GamesBotApiClientImpl
import org.marshalov.telekot.client.factories.ApiClientFactory

/**
 * Factory for creating of Games Telegram Bot API Client.
 */
object GamesBotApiClientFactory :
    ApiClientFactory<GamesBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): GamesBotApiClient =
        GamesBotApiClientImpl(apiToken, apiUrl, client)
}
