package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * This object represent a user's profile pictures (https://core.telegram.org/bots/api#userprofilephotos).
 */
@Serializable
data class UserProfilePhotos(
    /**
     * Total number of profile pictures the target user has
     */
    val totalCount: Int = 0,
    /**
     * Requested profile pictures (in up to 4 sizes each)
     */
    val photos: List<List<PhotoSize>> = emptyList()
) : TelegramObject
