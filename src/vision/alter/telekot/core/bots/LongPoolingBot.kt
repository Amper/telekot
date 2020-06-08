package vision.alter.telekot.core.bots

import vision.alter.telekot.client.BotApiClient
import vision.alter.telekot.core.UpdateProdiver
import vision.alter.telekot.core.updates.LongPoolingUpdateProvider
import vision.alter.telekot.telegram.model.updates.Update

/**
 * Simple long pooling bot.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param apiClient Telegram Bot API Client
 * @param updateProvider Providers of telegram update events.
 * @param updateHandler Function for handle incoming update events in bot.
 */
open class LongPoolingBot(
    apiToken: String,
    apiUrl: String? = null,
    apiClient: BotApiClient = BotApiClient(
        apiToken,
        apiUrl
    ),
    updateProvider: UpdateProdiver = LongPoolingUpdateProvider(
        apiClient
    ),
    protected open val updateHandler: suspend LongPoolingBot.(update: Update) -> Unit
): AbstractBot(apiClient, updateProvider) {
    override suspend fun onUpdate(update: Update) =
        this.updateHandler(update)
}
