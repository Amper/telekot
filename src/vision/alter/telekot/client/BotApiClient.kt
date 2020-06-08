package vision.alter.telekot.client

import io.ktor.client.HttpClient
import vision.alter.telekot.client.factories.BotApiClientFactory
import vision.alter.telekot.telegram.api.CommonBotApi
import vision.alter.telekot.telegram.api.GamesBotApi
import vision.alter.telekot.telegram.api.InlineBotApi
import vision.alter.telekot.telegram.api.MessageEditingBotApi
import vision.alter.telekot.telegram.api.PaymentsBotApi
import vision.alter.telekot.telegram.api.StickersBotApi
import vision.alter.telekot.telegram.api.TelegramApi
import vision.alter.telekot.telegram.api.UpdatesBotApi

/**
 * General interface for accessing all Telegram APIs.
 * @property commonApi Interface for accessing Common Telegram API (https://core.telegram.org/bots/api#available-methods)
 * @property updatesApi Interface for accessing Getting Updates Telegram API (https://core.telegram.org/bots/api#getting-updates)
 * @property inlineApi Interface for accessing Inline Mode Telegram API (https://core.telegram.org/bots/api#inline-mode)
 * @property paymentsApi Interface for accessing Payments Telegram API (https://core.telegram.org/bots/api#payments)
 * @property gamesApi Interface for accessing Games Telegram API (https://core.telegram.org/bots/api#games)
 */
interface BotApiClient : TelegramApi {
    /**
     * Interface for accessing Common Telegram API (https://core.telegram.org/bots/api#available-methods)
     */
    val commonApi: CommonBotApi

    /**
     * Interface for accessing Updating Messages Telegram API (https://core.telegram.org/bots/api#updating-messages)
     */
    val messageEditingApi: MessageEditingBotApi

    /**
     * Interface for accessing Getting Updates Telegram API (https://core.telegram.org/bots/api#getting-updates)
     */
    val updatesApi: UpdatesBotApi

    /**
     * Interface for accessing Inline Mode Telegram API (https://core.telegram.org/bots/api#inline-mode)
     */
    val inlineApi: InlineBotApi

    /**
     * Interface for accessing Payments Telegram API (https://core.telegram.org/bots/api#payments)
     */
    val paymentsApi: PaymentsBotApi

    /**
     * Interface for accessing Games Telegram API (https://core.telegram.org/bots/api#games)
     */
    val gamesApi: GamesBotApi

    /**
     * Interface for accessing Stickers Telegram API (https://core.telegram.org/bots/api#stickers)
     */
    val stickersApi: StickersBotApi

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
