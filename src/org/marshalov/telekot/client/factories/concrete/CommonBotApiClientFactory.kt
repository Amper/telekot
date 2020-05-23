package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.clients.CommonBotApiClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.telegram.api.CommonBotApi

/**
 * Factory for creating of Common Telegram Bot API Client.
 */
object CommonBotApiClientFactory :
    ApiClientFactory<CommonBotApi> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): CommonBotApi =
        CommonBotApiClient(apiToken, apiUrl, client)
}
