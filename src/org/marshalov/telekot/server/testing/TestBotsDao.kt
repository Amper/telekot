package org.marshalov.telekot.server.testing

import org.marshalov.telekot.server.dao.BotsDao
import org.marshalov.telekot.telegram.model.BotCommand
import org.marshalov.telekot.telegram.model.User

/**
 *
 */
class TestBotsDao : BotsDao {
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
    ): User {
        val botInfo = BotInfo(
            id = IdGenerator.getNextId(),
            owner = owner,
            description = description,
            about = about,
            commands = commands.toMutableList()
        )
        val userInfo = User(
            id = IdGenerator.getNextId(),
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
    ): Boolean {
        val result = token in usernamesByToken
        return result
    }

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
