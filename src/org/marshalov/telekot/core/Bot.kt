package org.marshalov.telekot.core

import org.marshalov.telekot.telegram.model.updates.Update

/**
 * Interface for creating telegram bot implementations.
 */
interface Bot {
    /**
     * Run bot (processing messages).
     */
    fun run()

    /**
     * Stop bot.
     */
    fun stop()

    /**
     * This method is called when the next event (update) is received.
     * @param update Full information about the received update.
     */
    suspend fun onUpdate(update: Update)
}
