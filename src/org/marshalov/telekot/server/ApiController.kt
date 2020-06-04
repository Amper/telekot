package org.marshalov.telekot.server

import org.marshalov.telekot.server.dao.UsersDao
import org.marshalov.telekot.telegram.api.TelegramApi

/**
 *
 */
interface ApiController : TelegramApi {
    /**
     *
     */
    fun setApiToken(apiToken: String)

    /**
     *
     */
    fun setBotManager(botManager: BotManager)

    /**
     *
     */
    fun setUsersDao(usersDao: UsersDao)
}
