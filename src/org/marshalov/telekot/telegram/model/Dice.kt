package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a dice with a random value from 1 to 6 for currently supported base emoji.
 * (Yes, we're aware of the “proper” singular of die.
 * But it's awkward, and we decided to help it change. One dice at a time!)
 * (https://core.telegram.org/bots/api#dice)
 */
@Serializable
data class Dice(
    /**
     * Emoji on which the dice throw animation is based
     */
    val emoji: String = "",
    /**
     * Value of the dice, 1-6 for currently supported base emoji
     */
    val value: Int = 0
) : TelegramObject
