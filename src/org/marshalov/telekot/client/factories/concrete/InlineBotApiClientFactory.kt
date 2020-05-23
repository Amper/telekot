package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.clients.InlineBotApiClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.telegram.api.InlineBotApi

/**
 * Factory for creating of Inline Mode Telegram Bot API Client.
 */
object InlineBotApiClientFactory :
    ApiClientFactory<InlineBotApi> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): InlineBotApi =
        InlineBotApiClient(apiToken, apiUrl, client)
}
