package vision.alter.telekot.telegram.model.passport

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Contains information about Telegram Passport data shared with the bot by the user (https://core.telegram.org/bots/api#passportdata).
 */
@Serializable
data class PassportData(
    /**
     * Array with information about documents and other Telegram Passport elements that was shared with the bot
     */
    val data: List<EncryptedPassportElement> = emptyList(),
    /**
     * Encrypted credentials required to decrypt the data
     */
    val credentials: EncryptedCredentials = EncryptedCredentials()
) : TelegramObject
