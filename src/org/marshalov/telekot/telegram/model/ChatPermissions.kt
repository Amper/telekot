package org.marshalov.telekot.telegram.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Describes actions that a non-administrator user is allowed to take in a chat (https://core.telegram.org/bots/api#chatpermissions).
 */
@Serializable
data class ChatPermissions(
    /**
     * Optional. True, if the user is allowed to send text messages, contacts, locations and venues
     */
    val canSendMessages: Boolean? = null,
    /**
     * Optional. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes, implies can_send_messages
     */
    val canSendMediaMessages: Boolean? = null,
    /**
     * Optional. True, if the user is allowed to send polls, implies can_send_messages
     */
    val canSendPolls: Boolean? = null,
    /**
     * Optional. True, if the user is allowed to send animations, games, stickers and use inline bots, implies can_send_media_messages
     */
    val canSendOtherMessages: Boolean? = null,
    /**
     * Optional. True, if the user is allowed to add web page previews to their messages, implies can_send_media_messages
     */
    val canAddWebPagePreviews: Boolean? = null,
    /**
     * Optional. True, if the user is allowed to change the chat title, photo and other settings. Ignored in public supergroups
     */
    val canChangeInfo: Boolean? = null,
    /**
     * Optional. True, if the user is allowed to invite new users to the chat
     */
    val canInviteUsers: Boolean? = null,
    /**
     * Optional. True, if the user is allowed to pin messages. Ignored in public supergroups
     */
    val canPinMessages: Boolean? = null
) : TelegramObject
