package org.marshalov.telekot.client.factories

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.client.api.CommonBotApiClient
import org.marshalov.telekot.client.api.InlineBotApiClient
import org.marshalov.telekot.client.api.UpdatesBotApiClient
import org.marshalov.telekot.client.factories.concrete.CommonBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.InlineBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.SimpleBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.UpdatesBotApiClientFactory

/**
 * Universal factory for creating of any Telegram Bot API Client.
 */
object BotApiClientFactory {
    inline fun <reified T> createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): T =
        // @TODO: ???
        when {
            T::class == BotApiClient::class ->
                SimpleBotApiClientFactory.createApiClient(apiToken, apiUrl, client) as T
            T::class == CommonBotApiClient::class ->
                CommonBotApiClientFactory.createApiClient(apiToken, apiUrl, client) as T
            T::class == InlineBotApiClient::class ->
                InlineBotApiClientFactory.createApiClient(apiToken, apiUrl, client) as T
            T::class == UpdatesBotApiClient::class ->
                UpdatesBotApiClientFactory.createApiClient(apiToken, apiUrl, client) as T
            else -> throw IllegalArgumentException("...")
        }
}
