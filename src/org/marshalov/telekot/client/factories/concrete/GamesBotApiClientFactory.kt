package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.clients.GamesBotApiClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.telegram.api.GamesBotApi

/**
 * Factory for creating of Games Telegram Bot API Client.
 */
object GamesBotApiClientFactory :
    ApiClientFactory<GamesBotApi> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): GamesBotApi =
        GamesBotApiClient(apiToken, apiUrl, client)
}
