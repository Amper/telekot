package vision.alter.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import vision.alter.telekot.client.clients.GamesBotApiClient
import vision.alter.telekot.client.factories.ApiClientFactory
import vision.alter.telekot.telegram.api.GamesBotApi

/**
 * Factory for creating of Games Telegram Bot API Client.
 */
object GamesBotApiClientFactory :
    ApiClientFactory<GamesBotApi> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): GamesBotApi =
        GamesBotApiClient(apiToken, apiUrl, client)
}
