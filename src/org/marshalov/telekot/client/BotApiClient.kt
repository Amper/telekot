package org.marshalov.telekot.client

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.CommonBotApiClient
import org.marshalov.telekot.client.api.InlineBotApiClient
import org.marshalov.telekot.client.api.UpdatesBotApiClient
import org.marshalov.telekot.client.factories.BotApiClientFactory

/**
 * General interface for accessing all Telegram APIs.
 * @property commonApi Interface for accessing Common Telegram API (https://core.telegram.org/bots/api#available-methods)
 * @property updatesApi Interface for accessing Getting Updates Telegram API (https://core.telegram.org/bots/api#getting-updates)
 * @property inlineApi Interface for accessing Inline Mode Telegram API (https://core.telegram.org/bots/api#inline-mode)
 */
interface BotApiClient {
    /**
     * Interface for accessing Common Telegram API (https://core.telegram.org/bots/api#available-methods)
     */
    val commonApi: CommonBotApiClient

    /**
     * Interface for accessing Getting Updates Telegram API (https://core.telegram.org/bots/api#getting-updates)
     */
    val updatesApi: UpdatesBotApiClient

    /**
     * Interface for accessing Inline Mode Telegram API (https://core.telegram.org/bots/api#inline-mode)
     */
    val inlineApi: InlineBotApiClient

    companion object {
        /**
         * Special factory method for creating API Client Instance.
         * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
         * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
         * @param client KTOR HTTP Client instance
         * @return Instance of BotApiClient
         */
        operator fun invoke(
            apiToken: String,
            apiUrl: String? = null,
            client: HttpClient? = null
        ): BotApiClient =
            BotApiClientFactory.createApiClient(apiToken, apiUrl, client)
    }
}
