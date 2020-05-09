package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.client.impl.BotApiClientImpl

/**
 * Factory for creating of General Telegram Bot API Client.
 */
object SimpleBotApiClientFactory :
    ApiClientFactory<BotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): BotApiClient =
        BotApiClientImpl(apiToken, apiUrl, client)
}
