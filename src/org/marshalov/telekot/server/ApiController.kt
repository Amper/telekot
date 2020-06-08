package org.marshalov.telekot.server

import org.marshalov.telekot.server.dao.UsersDao
import org.marshalov.telekot.telegram.api.TelegramApi

/**
 * Telegram API Server Controller interface.
 */
interface ApiController : TelegramApi {
    /**
     * Set API token.
     * @param apiToken Telegram API token.
     */
    fun setApiToken(apiToken: String)

    /**
     * Set bot manager
     * @param botManager Bot Manager.
     */
    fun setBotManager(botManager: BotManager)

    /**
     * Set users DAO.
     * @param usersDao Users DAO.
     */
    fun setUsersDao(usersDao: UsersDao)
}
