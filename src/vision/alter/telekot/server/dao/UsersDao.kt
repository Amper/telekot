package vision.alter.telekot.server.dao

import vision.alter.telekot.telegram.model.BotCommand
import vision.alter.telekot.telegram.model.User

/**
 *
 */
@SuppressWarnings("LongParameterList")
interface UsersDao {
    /**
     *
     */
    suspend fun saveBot(
        owner: String,
        token: String,
        name: String,
        username: String,
        description: String,
        about: String,
        commands: List<BotCommand>,
        joinGroups: Boolean,
        privacyMode: Boolean,
        inlineMode: Boolean
    ): User

    /**
     *
     */
    suspend fun tokenExists(
        token: String
    ): Boolean

    /**
     *
     */
    suspend fun getBotByToken(
        token: String
    ): User

    /**
     *
     */
    suspend fun getBotByUsername(
        username: String
    ): User
}
