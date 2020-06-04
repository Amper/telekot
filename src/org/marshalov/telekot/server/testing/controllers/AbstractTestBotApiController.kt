package org.marshalov.telekot.server.testing.controllers

import org.marshalov.telekot.server.ApiController
import org.marshalov.telekot.server.BotManager
import org.marshalov.telekot.server.dao.UsersDao

/**
 *
 */
@SuppressWarnings("LateinitUsage")
abstract class AbstractTestBotApiController : ApiController {
    override fun setApiToken(apiToken: String) { this.token = apiToken }
    override fun setBotManager(botManager: BotManager) { this.manager = botManager }
    override fun setUsersDao(usersDao: UsersDao) { this.dao = usersDao }

    /**
     *
     */
    protected var token: String = ""

    /**
     *
     */
    protected lateinit var manager: BotManager

    /**
     *
     */
    protected lateinit var dao: UsersDao
}
