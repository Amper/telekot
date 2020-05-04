package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.client.api.impl.BotApiClientImpl
import org.marshalov.telekot.client.factories.ApiClientFactory

object SimpleBotApiClientFactory :
    ApiClientFactory<BotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): BotApiClient =
        BotApiClientImpl(apiToken, apiUrl, client)
}
