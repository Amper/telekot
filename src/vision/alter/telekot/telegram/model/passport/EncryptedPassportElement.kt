package vision.alter.telekot.telegram.model.passport

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * Contains information about documents or other Telegram Passport elements shared with the bot by the user.
 * (https://core.telegram.org/bots/api#encryptedpassportelement)
 */
@Serializable
data class EncryptedPassportElement(
    /**
     * Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”,
     * “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”,
     * “passport_registration”, “temporary_registration”, “phone_number”, “email”.
     */
    val type: String = "",
    /**
     * Optional. Base64-encoded encrypted Telegram Passport element data provided by the user,
     * available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”
     * and “address” types. Can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    val data: String? = null,
    /**
     * Optional. User's verified phone number, available only for “phone_number” type
     */
    val phoneNumber: String? = null,
    /**
     * Optional. User's verified email address, available only for “email” type
     */
    val email: String? = null,
    /**
     * Optional. Array of encrypted files with documents provided by the user, available for “utility_bill”,
     * “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types.
     * Files can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    val files: List<PassportFile>? = null,
    /**
     * Optional. Encrypted file with the front side of the document, provided by the user.
     * Available for “passport”, “driver_license”, “identity_card” and “internal_passport”.
     * The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    val frontSide: PassportFile? = null,
    /**
     * Optional. Encrypted file with the reverse side of the document, provided by the user.
     * Available for “driver_license” and “identity_card”.
     * The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    val reverseSide: PassportFile? = null,
    /**
     * Optional. Encrypted file with the selfie of the user holding a document, provided by the user;
     * available for “passport”, “driver_license”, “identity_card” and “internal_passport”.
     * The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    val selfie: PassportFile? = null,
    /**
     * Optional. Array of encrypted files with translated versions of documents provided by the user.
     * Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”,
     * “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”
     * and “temporary_registration” types.
     * Files can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    val translation: List<PassportFile>? = null,
    /**
     * Base64-encoded element hash for using in PassportElementErrorUnspecified
     */
    val hash: String? = null
) : TelegramObject
