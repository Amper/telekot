package vision.alter.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import vision.alter.telekot.client.BotApiClient
import vision.alter.telekot.client.clients.BotApiClientImpl
import vision.alter.telekot.client.factories.ApiClientFactory

/**
 * Factory for creating of General Telegram Bot API Client.
 */
object SimpleBotApiClientFactory :
    ApiClientFactory<BotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): BotApiClient =
        BotApiClientImpl(apiToken, apiUrl, client)
}
