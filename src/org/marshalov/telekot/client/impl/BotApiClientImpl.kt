package org.marshalov.telekot.client.impl

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.client.factories.BotApiClientFactory
import org.marshalov.telekot.client.factories.HttpClientFactory
import org.marshalov.telekot.telegram.api.CommonBotApiClient
import org.marshalov.telekot.telegram.api.GamesBotApiClient
import org.marshalov.telekot.telegram.api.InlineBotApiClient
import org.marshalov.telekot.telegram.api.MessageEditingBotApiClient
import org.marshalov.telekot.telegram.api.PaymentsBotApiClient
import org.marshalov.telekot.telegram.api.StickersBotApiClient
import org.marshalov.telekot.telegram.api.UpdatesBotApiClient

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
    override val messageEditingApi: MessageEditingBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val updatesApi: UpdatesBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val inlineApi: InlineBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val paymentsApi: PaymentsBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val gamesApi: GamesBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val stickersApi: StickersBotApiClient = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
}
