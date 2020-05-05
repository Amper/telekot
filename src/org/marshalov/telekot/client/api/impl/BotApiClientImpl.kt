package org.marshalov.telekot.client.api.impl

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.client.api.CommonBotApiClient
import org.marshalov.telekot.client.api.InlineBotApiClient
import org.marshalov.telekot.client.api.PaymentsBotApiClient
import org.marshalov.telekot.client.api.UpdatesBotApiClient
import org.marshalov.telekot.client.factories.BotApiClientFactory
import org.marshalov.telekot.client.factories.HttpClientFactory

/**
 * Implementation of general interface for accessing all Telegram APIs.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 */
class BotApiClientImpl(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) : BotApiClient {
    private val httpClient: HttpClient = client ?: HttpClientFactory.createHttpClient()
    override val commonApi: CommonBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val updatesApi: UpdatesBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val inlineApi: InlineBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val paymentsApi: PaymentsBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
}
