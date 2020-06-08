package vision.alter.telekot.server

import vision.alter.telekot.telegram.model.BotCommand
import vision.alter.telekot.telegram.model.User

/**
 * Telegram Bot API Server.
 */
interface BotManager {
    /**
     * Creating a new bot.
     * @param owner Bot owner's username.
     * @param name Bot's name.
     * @param username A username for your bot. It must end in `bot`. Like this, for example: TetrisBot or tetris_bot.
     * @param description Bot description.
     * @param about Bot about info.
     * @param commands The list of commands.
     * @param joinGroups Can your bot be added to groups?
     * @param privacyMode Privacy mode in groups.
     * @param inlineMode Inline mode.
     * @return bot token string.
     */
    suspend fun createBot(
        owner: String,
        name: String,
        username: String,
        description: String? = null,
        about: String? = null,
        commands: List<BotCommand>? = null,
        joinGroups: Boolean? = null,
        privacyMode: Boolean? = null,
        inlineMode: Boolean? = null
    ): String

    /**
     * Checking the validity of the token.
     */
    suspend fun isTokenValid(
        token: String
    ): Boolean

    /**
     * Get a bot's information.
     * @param token Bot's username or token.
     * @return Bot's (bot user) information
     */
    suspend fun getBotInfo(
        username: String
    ): User

    /**
     * Change a bot's information.
     * @param token Bot's username or token.
     * @param name New bot's name (or null to keep it unchanged)
     * @param description New bot's description (or null to keep it unchanged)
     * @param about New bot's about (or null to keep it unchanged)
     * @return New (after changing) bot's information
     */
    suspend fun changeBotInfo(
        username: String,
        name: String? = null,
        description: String? = null,
        about: String? = null,
        commands: List<BotCommand>? = null,
        joinGroups: Boolean? = null,
        privacyMode: Boolean? = null,
        inlineMode: Boolean? = null
    ): User

    /**
     * Get list of bot commands.
     * @param token Bot's username or token.
     * @return List of bot commands
     */
    fun getBotCommands(
        username: String
    ): List<BotCommand>

    /**
     * Delete a bot.
     * @param username Bot's username or token.
     * @return True on success.
     */
    suspend fun deleteBot(
        username: String
    ): Boolean

    /**
     * Generate a token for bot.
     * @param username Bot's username or token.
     * @return token string.
     */
    suspend fun generateToken(
        username: String
    ): String

    /**
     * Generate a new token (old token will stop working).
     * @param username Bot's username or token.
     * @return token string.
     */
    suspend fun revokeToken(
        username: String
    ): String
}
