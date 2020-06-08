package vision.alter.telekot.client.factories

import io.ktor.client.HttpClient
import vision.alter.telekot.telegram.api.TelegramApi

/**
 * Interface for factories of other Telegram API clients.
 */
interface ApiClientFactory<T : TelegramApi> {
    /**
     * Create Telegram API Client for generic interface.
     * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
     * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
     * @param client KTOR HTTP Client instance
     * @return Instance of Telegram API Client with generic interface
     */
    fun createApiClient(
        apiToken: String,
        apiUrl: String? = null,
        client: HttpClient? = null
    ): T
}
