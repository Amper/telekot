package vision.alter.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import vision.alter.telekot.client.clients.CommonBotApiClient
import vision.alter.telekot.client.factories.ApiClientFactory
import vision.alter.telekot.telegram.api.CommonBotApi

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
