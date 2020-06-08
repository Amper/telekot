package vision.alter.telekot.telegram.model.passport

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a file uploaded to Telegram Passport (https://core.telegram.org/bots/api#passportfile).
 * Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.
 */
@Serializable
data class PassportFile(
    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    val fileId: String = "",
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    val fileUniqueId: String = "",
    /**
     * File size
     */
    val fileSize: Int = -1,
    /**
     * Unix time when the file was uploaded
     */
    val fileDate: Int = -1
) : TelegramObject
