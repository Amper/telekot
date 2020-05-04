package org.marshalov.telekot.client.model.games

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * A placeholder, currently holds no information. Use BotFather to set up your game.
 */
@Serializable
data class CallbackGame(
    // @TODO: This field must be removed
    val removeThisField: Boolean? = null
) : TelegramObject
