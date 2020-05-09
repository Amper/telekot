package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a video message (available in Telegram apps as of v.4.0) (https://core.telegram.org/bots/api#videonote).
 */
@Serializable
data class VideoNote(
    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    val fileId: String = "",
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    val fileUniqueId: String = "",
    /**
     * Video width and height (diameter of the video message) as defined by sender
     */
    val length: Int = -1,
    /**
     * Duration of the video in seconds as defined by sender
     */
    val duration: Int = -1,
    /**
     * Optional. Video thumbnail
     */
    val thumb: PhotoSize? = null,
    /**
     * Optional. File size
     */
    val fileSize: Int? = null
) : TelegramObject
