package org.marshalov.telekot.core

import org.marshalov.telekot.telegram.model.updates.Update

/**
 *
 */
interface UpdateProdiver {
    /**
     *
     */
    val subscriptions: Set<String>

    /**
     *
     */
    fun subscribe(
        id: String,
        handler: suspend (update: Update) -> Unit
    )

    /**
     *
     */
    fun unsubscribe(
        id: String
    )

    /**
     *
     */
    fun resetSubscriptions()

    /**
     *
     */
    fun run()

    /**
     *
     */
    fun stop()
}
