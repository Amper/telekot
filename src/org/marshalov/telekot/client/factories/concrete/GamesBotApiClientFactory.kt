package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.client.impl.GamesBotApiClientImpl
import org.marshalov.telekot.telegram.api.GamesBotApiClient

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
