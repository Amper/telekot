package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.client.impl.InlineBotApiClientImpl
import org.marshalov.telekot.telegram.api.InlineBotApiClient

/**
 * Factory for creating of Inline Mode Telegram Bot API Client.
 */
object InlineBotApiClientFactory :
    ApiClientFactory<InlineBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): InlineBotApiClient =
        InlineBotApiClientImpl(apiToken, apiUrl, client)
}
