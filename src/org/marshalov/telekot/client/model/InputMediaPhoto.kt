package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.InputMediaPhotoOrVideo
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * Represents a photo to be sent (https://core.telegram.org/bots/api#inputmediaphoto).
 */
@Serializable
data class InputMediaPhoto(
    /**
     * Type of the result, must be photo
     */
    val type: String = "photo",
    /**
     * File to send.
     * Pass a fileId to send a file that exists on the Telegram servers (recommended),
     * pass an HTTP URL for Telegram to get a file from the Internet, or pass “attach://<file_attach_name>”
     * to upload a new one using multipart/form-data under <file_attach_name> name.
     */
    val media: String = "",
    /**
     * Optional. Caption of the photo to be sent, 0-1024 characters after entities parsing
     */
    val caption: String? = null,
    /**
     * Optional. Mode for parsing entities in the photo caption. See formatting options for more details.
     */
    // @TODO: enum
    val parseMode: String? = null
) : TelegramObject,
    InputMedia,
    InputMediaPhotoOrVideo
