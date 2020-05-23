package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.clients.MessageEditingBotApiClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.telegram.api.MessageEditingBotApi

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
