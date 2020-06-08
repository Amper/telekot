package vision.alter.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import vision.alter.telekot.client.clients.UpdatesBotApiClient
import vision.alter.telekot.client.factories.ApiClientFactory
import vision.alter.telekot.telegram.api.UpdatesBotApi

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
