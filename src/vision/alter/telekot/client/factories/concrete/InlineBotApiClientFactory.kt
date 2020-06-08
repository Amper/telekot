package vision.alter.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import vision.alter.telekot.client.clients.InlineBotApiClient
import vision.alter.telekot.client.factories.ApiClientFactory
import vision.alter.telekot.telegram.api.InlineBotApi

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
