package org.marshalov.telekot.core

import org.marshalov.telekot.telegram.model.updates.Update

/**
 * Interface for providers of telegram update events.
 * @property The set of identifiers of subscribers for updates.
 */
interface UpdateProdiver {
    /**
     * The set of identifiers of subscribers for updates.
     */
    val subscriptions: Set<String>

    /**
     * Subscribe to updates with the specified ID and event handler.
     * @param id Subsriber identifier.
     * @param handler Event handler for subsriber.
     */
    fun subscribe(
        id: String,
        handler: suspend (update: Update) -> Unit
    )

    /**
     * Unsubscribe from the event stream with the specified ID.
     * @param id Subsriber identifier.
     */
    fun unsubscribe(
        id: String
    )

    /**
     * Clear (unsibsribe) for all subscriptions.
     */
    fun resetSubscriptions()

    /**
     * Run processing of events for this update provider.
     */
    fun run()

    /**
     * Stop processing of events for this update provider.
     */
    fun stop()
}
