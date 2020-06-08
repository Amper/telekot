package org.marshalov.telekot.core.bots

import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.core.Bot
import org.marshalov.telekot.core.UpdateProdiver

/**
 * Abstract class for creating telegram bot implementations
 * (contains simple logic for the bot to work: run and stop methods).
 * @property apiClient Client for accessing Telegram APIs.
 * @property updateProvider Provider of telegram update events.
 */
abstract class AbstractBot(
    /**
     * Client for accessing Telegram APIs.
     */
    protected open val apiClient: BotApiClient,
    /**
     * Provider of telegram update events.
     */
    protected open val updateProvider: UpdateProdiver
): Bot {
    override fun run() {
        updateProvider.subscribe(
            id = this::class.java.toString() + "->" + this.hashCode().toString(),
            handler = ::onUpdate
        )
        updateProvider.run()
    }

    override fun stop() {
        updateProvider.stop()
        updateProvider.resetSubscriptions()
    }
}
