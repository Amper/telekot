package org.marshalov.telekot.server.dao

import org.marshalov.telekot.telegram.model.BotCommand
import org.marshalov.telekot.telegram.model.User

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
