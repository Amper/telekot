package vision.alter.telekot.telegram.model.markers

import vision.alter.telekot.telegram.model.InputMedia

/**
 * Marking interface for photos and videos to be sent (for MediaGroup).
 * @see vision.alter.telekot.telegram.api.CommonBotApi.sendMediaGroup
 * @see vision.alter.telekot.telegram.model.InputMediaPhoto
 * @see vision.alter.telekot.telegram.model.InputMediaVideo
 */
interface InputMediaPhotoOrVideo : InputMedia
