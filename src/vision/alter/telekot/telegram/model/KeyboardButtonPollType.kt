package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents type of a poll,
 * which is allowed to be created and sent when the corresponding button is pressed.
 * (https://core.telegram.org/bots/api#keyboardbuttonpolltype)
 */
@Serializable
data class KeyboardButtonPollType(
    /**
     * Optional. If quiz is passed, the user will be allowed to create only polls in the quiz mode.
     * If regular is passed, only regular polls will be allowed.
     * Otherwise, the user will be allowed to create a poll of any type.
     */
    val type: String = ""
) : TelegramObject
