package org.marshalov.telekot.core.updates

import java.util.concurrent.ConcurrentHashMap
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.core.UpdateProdiver
import org.marshalov.telekot.telegram.model.updates.Update

/**
 * Abstract class for providers of telegram update events
 * (contains simple logic for working with subscriptions).
 * @param apiClient Telegram Bot API Client.
 */
abstract class AbstractUpdateProvider(
    protected val apiClient: BotApiClient
) : UpdateProdiver {
    override val subscriptions: Set<String>
        get() = handlers.keys

    override fun subscribe(id: String, handler: suspend (update: Update) -> Unit) {
        handlers[id] = handler
    }

    override fun unsubscribe(id: String) {
        handlers.remove(id)
    }

    override fun resetSubscriptions() {
        handlers.clear()
    }

    protected val handlers: MutableMap<String, suspend (update: Update) -> Unit> = ConcurrentHashMap()
}
