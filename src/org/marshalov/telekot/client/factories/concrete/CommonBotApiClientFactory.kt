package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.client.impl.CommonBotApiClientImpl
import org.marshalov.telekot.telegram.api.CommonBotApiClient

/**
 * Factory for creating of Common Telegram Bot API Client.
 */
object CommonBotApiClientFactory :
    ApiClientFactory<CommonBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): CommonBotApiClient =
        CommonBotApiClientImpl(apiToken, apiUrl, client)
}
