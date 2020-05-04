package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) (https://core.telegram.org/bots/api#animation).
 */
@Serializable
data class Animation(
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
     * Optional. Animation thumbnail as defined by sender
     */
    val thumb: PhotoSize? = null,
    /**
     * Optional. Original animation filename as defined by sender
     */
    val fileName: String? = null,
    /**
     * Optional. MIME type of the file as defined by sender
     */
    val mimeType: String? = null,
    /**
     * Optional. File size
     */
    val fileSize: Int? = null
) : TelegramObject
