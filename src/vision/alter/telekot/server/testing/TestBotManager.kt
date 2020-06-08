package vision.alter.telekot.server.testing

import java.util.UUID
import kotlin.math.absoluteValue
import kotlin.random.Random
import vision.alter.telekot.server.BotManager
import vision.alter.telekot.server.dao.UsersDao
import vision.alter.telekot.telegram.model.BotCommand
import vision.alter.telekot.telegram.model.User

/**
 *
 */
class TestBotManager(
    private val dao: UsersDao
) : BotManager {
    override suspend fun createBot(
        owner: String,
        name: String,
        username: String,
        description: String?,
        about: String?,
        commands: List<BotCommand>?,
        joinGroups: Boolean?,
        privacyMode: Boolean?,
        inlineMode: Boolean?
    ): String {
        require(owner.isNotBlank()) { "The `owner` parameter cannot be blank!" }
        require(username.isNotBlank()) { "The `username` parameter cannot be blank!" }
        require(name.isNotBlank()) { "The `name` parameter cannot be blank!" }
        require(username.all { it.isLetterOrDigit() || it == '_' }) { "The `username` parameter must be a valid identifier!" }
        require(username.toLowerCase().endsWith("bot")) { "The `username` parameter must ends with `bot` or `Bot`" }

        val token = generateNewToken()

        dao.saveBot(
            owner = owner,
            token = token,
            name = name,
            username = username,
            description = description ?: "",
            about = about ?: "",
            commands = commands ?: emptyList(),
            joinGroups = joinGroups ?: false,
            privacyMode = privacyMode ?: true,
            inlineMode = inlineMode ?: false
        )

        return token
    }

    override suspend fun isTokenValid(
        token: String
    ): Boolean =
        dao.tokenExists(token)

    override suspend fun getBotInfo(
        username: String
    ): User =
        when {
            ":" in username -> dao.getBotByToken(username)
            else -> dao.getBotByUsername(username)
        }

    override suspend fun changeBotInfo(
        username: String,
        name: String?,
        description: String?,
        about: String?,
        commands: List<BotCommand>?,
        joinGroups: Boolean?,
        privacyMode: Boolean?,
        inlineMode: Boolean?
    ): User =
        TODO("Not yet implemented")

    override fun getBotCommands(
        username: String
    ): List<BotCommand> =
        TODO("Not yet implemented")

    override suspend fun deleteBot(
        username: String
    ): Boolean =
        TODO("Not yet implemented")

    override suspend fun generateToken(
        username: String
    ): String =
        TODO("Not yet implemented")

    override suspend fun revokeToken(
        username: String
    ): String =
        TODO("Not yet implemented")

    // ------------------------------------------------------------------------------------------------------------- //

    private fun generateNewToken(): String {
        val first = Random.nextLong().absoluteValue.toString()
        val second = UUID.randomUUID()
        return "$first:$second"
    }
}
