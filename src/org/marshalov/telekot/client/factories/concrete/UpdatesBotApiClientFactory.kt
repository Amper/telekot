package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.clients.UpdatesBotApiClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.telegram.api.UpdatesBotApi

/**
 * Factory for creating of Getting Updates Telegram Bot API Client.
 */
object UpdatesBotApiClientFactory :
    ApiClientFactory<UpdatesBotApi> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): UpdatesBotApi =
        UpdatesBotApiClient(apiToken, apiUrl, client)
}
