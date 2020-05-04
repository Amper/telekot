package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.InlineBotApiClient
import org.marshalov.telekot.client.api.impl.InlineBotApiClientImpl
import org.marshalov.telekot.client.factories.ApiClientFactory

object InlineBotApiClientFactory :
    ApiClientFactory<InlineBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): InlineBotApiClient =
        InlineBotApiClientImpl(apiToken, apiUrl, client)
}
