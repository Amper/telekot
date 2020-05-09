package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.client.impl.MessageEditingBotApiClientImpl
import org.marshalov.telekot.telegram.api.MessageEditingBotApiClient

/**
 * Factory for creating of Updating Messages Mode Telegram Bot API Client.
 */
object MessageEditingBotApiClientFactory :
    ApiClientFactory<MessageEditingBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): MessageEditingBotApiClient =
        MessageEditingBotApiClientImpl(apiToken, apiUrl, client)
}
