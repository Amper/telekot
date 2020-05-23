package org.marshalov.telekot.client.clients

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.client.factories.BotApiClientFactory
import org.marshalov.telekot.client.factories.HttpClientFactory
import org.marshalov.telekot.telegram.api.CommonBotApi
import org.marshalov.telekot.telegram.api.GamesBotApi
import org.marshalov.telekot.telegram.api.InlineBotApi
import org.marshalov.telekot.telegram.api.MessageEditingBotApi
import org.marshalov.telekot.telegram.api.PaymentsBotApi
import org.marshalov.telekot.telegram.api.StickersBotApi
import org.marshalov.telekot.telegram.api.UpdatesBotApi

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
    override val commonApi: CommonBotApi = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val messageEditingApi: MessageEditingBotApi = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val updatesApi: UpdatesBotApi = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val inlineApi: InlineBotApi = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val paymentsApi: PaymentsBotApi = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val gamesApi: GamesBotApi = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
    override val stickersApi: StickersBotApi = BotApiClientFactory.createApiClient(apiToken, apiUrl, httpClient)
}
