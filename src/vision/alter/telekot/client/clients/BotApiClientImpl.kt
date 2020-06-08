package vision.alter.telekot.client.clients

import io.ktor.client.HttpClient
import vision.alter.telekot.client.BotApiClient
import vision.alter.telekot.client.factories.BotApiClientFactory
import vision.alter.telekot.client.factories.HttpClientFactory
import vision.alter.telekot.telegram.api.CommonBotApi
import vision.alter.telekot.telegram.api.GamesBotApi
import vision.alter.telekot.telegram.api.InlineBotApi
import vision.alter.telekot.telegram.api.MessageEditingBotApi
import vision.alter.telekot.telegram.api.PaymentsBotApi
import vision.alter.telekot.telegram.api.StickersBotApi
import vision.alter.telekot.telegram.api.UpdatesBotApi

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
