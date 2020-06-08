package vision.alter.telekot.server

import vision.alter.telekot.server.dao.UsersDao
import vision.alter.telekot.telegram.api.TelegramApi

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
