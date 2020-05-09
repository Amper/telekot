package org.marshalov.telekot.telegram.model.markers

import org.marshalov.telekot.telegram.model.InputMedia

/**
 * Marking interface for photos and videos to be sent (for MediaGroup).
 * @see org.marshalov.telekot.client.api.CommonBotApiClient.sendMediaGroup
 * @see org.marshalov.telekot.client.model.InputMediaPhoto
 * @see org.marshalov.telekot.client.model.InputMediaVideo
 */
interface InputMediaPhotoOrVideo : InputMedia
