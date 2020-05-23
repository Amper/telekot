package org.marshalov.telekot.server

import org.marshalov.telekot.telegram.api.TelegramApi

/**
 *
 */
interface ApiController : TelegramApi {
    /**
     *
     */
    fun setToken(token: String)

    /**
     *
     */
    fun setBotManager(botManager: BotManager)
}
