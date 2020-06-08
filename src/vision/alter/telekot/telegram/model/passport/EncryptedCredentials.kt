package vision.alter.telekot.telegram.model.passport

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Contains data required for decrypting and authenticating EncryptedPassportElement
 * (https://core.telegram.org/bots/api#encryptedcredentials).
 * See the Telegram Passport Documentation (https://core.telegram.org/passport#receiving-information) for
 * a complete description of the data decryption and authentication processes.
 */
@Serializable
data class EncryptedCredentials(
    /**
     * Base64-encoded encrypted JSON-serialized data with unique user's payload,
     * data hashes and secrets required for EncryptedPassportElement decryption and authentication
     */
    val data: String = "",
    /**
     * Base64-encoded data hash for data authentication
     */
    val hash: String = "",
    /**
     * Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
     */
    val secret: String = ""
) : TelegramObject
