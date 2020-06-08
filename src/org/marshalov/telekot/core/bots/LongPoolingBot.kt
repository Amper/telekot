package org.marshalov.telekot.core.bots

import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.core.UpdateProdiver
import org.marshalov.telekot.core.updates.LongPoolingUpdateProvider
import org.marshalov.telekot.telegram.model.updates.Update

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
    apiClient: BotApiClient = BotApiClient(apiToken, apiUrl),
    updateProvider: UpdateProdiver = LongPoolingUpdateProvider(apiClient),
    protected open val updateHandler: suspend LongPoolingBot.(update: Update) -> Unit
): AbstractBot(apiClient, updateProvider) {
    override suspend fun onUpdate(update: Update) =
        this.updateHandler(update)
}
