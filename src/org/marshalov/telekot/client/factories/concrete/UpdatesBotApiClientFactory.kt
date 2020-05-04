package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.UpdatesBotApiClient
import org.marshalov.telekot.client.api.impl.UpdatesBotApiClientImpl
import org.marshalov.telekot.client.factories.ApiClientFactory

object UpdatesBotApiClientFactory :
    ApiClientFactory<UpdatesBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): UpdatesBotApiClient =
        UpdatesBotApiClientImpl(apiToken, apiUrl, client)
}
