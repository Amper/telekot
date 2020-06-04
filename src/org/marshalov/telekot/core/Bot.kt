package org.marshalov.telekot.core

import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.telegram.model.updates.Update

/**
 *
 */
interface Bot {
    /**
     *
     */
    val apiClient: BotApiClient

    /**
     *
     */
    val updateProvider: UpdateProdiver

    /**
     *
     */
    fun run() {
        updateProvider.subscribe(
            id = this::class.java.toString() + "->" + this.hashCode().toString(),
            handler = ::onUpdate
        )
        updateProvider.run()
    }

    /**
     *
     */
    fun stop() {
        updateProvider.stop()
        updateProvider.resetSubscriptions()
    }

    /**
     *
     */
    suspend fun onUpdate(update: Update)
}
