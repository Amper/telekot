package org.marshalov.telekot.client.model

import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object represents the content of a media message to be sent. It should be one of:
 * @see InputMediaAnimation
 * @see InputMediaDocument
 * @see InputMediaAudio
 * @see InputMediaPhoto
 * @see InputMediaVideo
 */
interface InputMedia : TelegramObject
