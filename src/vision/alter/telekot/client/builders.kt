package vision.alter.telekot.client

import io.ktor.client.HttpClient
import kotlin.reflect.KClass
import vision.alter.telekot.client.factories.BotApiClientFactory

/**
 * Special factory method for creating API Client Instance.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 * @return Instance of BotApiClient
 */
operator fun KClass<BotApiClient>.invoke(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
): BotApiClient =
    BotApiClientFactory.createApiClient(apiToken, apiUrl, client)

/**
 * Special factory method for creating API Client Instance.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 * @return Instance of BotApiClient
 */
operator fun BotApiClient.Companion.invoke(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
): BotApiClient =
    BotApiClientFactory.createApiClient(apiToken, apiUrl, client)
