package vision.alter.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import vision.alter.telekot.client.clients.MessageEditingBotApiClient
import vision.alter.telekot.client.factories.ApiClientFactory
import vision.alter.telekot.telegram.api.MessageEditingBotApi

/**
 * Factory for creating of Updating Messages Mode Telegram Bot API Client.
 */
object MessageEditingBotApiClientFactory :
    ApiClientFactory<MessageEditingBotApi> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): MessageEditingBotApi =
        MessageEditingBotApiClient(apiToken, apiUrl, client)
}
