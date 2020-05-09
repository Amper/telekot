package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a video file (https://core.telegram.org/bots/api#video).
 */
@Serializable
data class Video(
    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    val fileId: String = "",
    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    val fileUniqueId: String = "",
    /**
     * Video width as defined by sender
     */
    val width: Int = -1,
    /**
     * Video height as defined by sender
     */
    val height: Int = -1,
    /**
     * Duration of the video in seconds as defined by sender
     */
    val duration: Int = -1,
    /**
     * Optional. Video thumbnail
     */
    val thumb: PhotoSize? = null,
    /**
     * Optional. Mime type of a file as defined by sender
     */
    val mimeType: String? = null,
    /**
     * Optional. File size
     */
    val fileSize: Int? = null
) : TelegramObject
