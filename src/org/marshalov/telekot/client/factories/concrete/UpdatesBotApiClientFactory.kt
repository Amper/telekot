package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.client.impl.UpdatesBotApiClientImpl
import org.marshalov.telekot.telegram.api.UpdatesBotApiClient

/**
 * Factory for creating of Getting Updates Telegram Bot API Client.
 */
object UpdatesBotApiClientFactory :
    ApiClientFactory<UpdatesBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): UpdatesBotApiClient =
        UpdatesBotApiClientImpl(apiToken, apiUrl, client)
}
