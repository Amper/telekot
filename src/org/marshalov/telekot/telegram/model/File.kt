package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a file ready to be downloaded.
 * The file can be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>.
 * It is guaranteed that the link will be valid for at least 1 hour.
 * When the link expires, a new one can be requested by calling getFile.
 * Maximum file size to download is 20 MB.
 * (https://core.telegram.org/bots/api#file)
 * @see org.marshalov.telekot.messengers.telegram.client.CommonBotApiClient.getFile
 */
@Serializable
data class File(
    /**
     * Identifier for this file, which can be used to download or reuse the file.
     */
    val fileId: String = "",
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots.
     * Can't be used to download or reuse the file.
     */
    val fileUniqueId: String = "",
    /**
     * Optional. File size, if known.
     */
    val fileSize: Int? = null,
    /**
     * Optional. File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
     */
    val filePath: String? = null
) : TelegramObject
