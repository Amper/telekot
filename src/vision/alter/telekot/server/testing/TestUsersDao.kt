package vision.alter.telekot.server.testing

import vision.alter.telekot.server.dao.UsersDao
import vision.alter.telekot.telegram.model.BotCommand
import vision.alter.telekot.telegram.model.User

/**
 *
 */
class TestUsersDao : UsersDao {
    override suspend fun saveBot(
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
    ): User = synchronized(this) {
        val botId = when {
            username in bots -> bots[username]?.id
            token in usernamesByToken -> bots[usernamesByToken[token]]?.id
            else -> null
        } ?: IdGenerator.getNextId()
        val botInfo = BotInfo(
            id = botId,
            owner = owner,
            description = description,
            about = about,
            commands = commands.toMutableList()
        )
        val userInfo = User(
            id = botId,
            isBot = true,
            firstName = name,
            username = username,
            canJoinGroups = joinGroups,
            supportsInlineQueries = inlineMode,
            canReadAllGroupMessages = !privacyMode
        )
        users[username] = userInfo
        bots[username] = botInfo
        usernamesById[botInfo.id] = username
        usernamesById[userInfo.id] = username
        usernamesByToken[token] = username
        return userInfo
    }

    override suspend fun tokenExists(
        token: String
    ): Boolean =
        token in usernamesByToken

    override suspend fun getBotByToken(
        token: String
    ): User =
        usernamesByToken[token]
            ?.let { username -> getBotByUsername(username) }
            ?: throw IllegalArgumentException("Not found Bot for this token")

    override suspend fun getBotByUsername(
        username: String
    ): User =
        users[username]
            ?.takeIf { user -> user.isBot }
            ?: throw IllegalArgumentException("Not found Bot for this token")

// ------------------------------------------------------------------------------------------------------------- //

    private data class BotInfo(
        var id: Long,
        var owner: String,
        var description: String,
        var about: String,
        var commands: MutableList<BotCommand>
    )

    private val bots: MutableMap<String, BotInfo> = mutableMapOf()
    private val users: MutableMap<String, User> = mutableMapOf()
    private val usernamesByToken: MutableMap<String, String> = mutableMapOf()
    private val usernamesById: MutableMap<Long, String> = mutableMapOf()
}
