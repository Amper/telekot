package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.markers.TelegramObject

/**
 * This object contains information about one member of a chat (https://core.telegram.org/bots/api#chatmember).
 */
@Serializable
data class ChatMember(
    /**
     * Information about the user
     */
    val user: User = User(),
    /**
     * The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”
     */
    val status: String = "",
    /**
     * Optional. Owner and administrators only.
     * Custom title for this user
     */
    val customTitle: String? = null,
    /**
     * Optional. Restricted and kicked only.
     * Date when restrictions will be lifted for this user; unix time
     */
    val untilDate: Int? = null,
    /**
     * Optional. Administrators only.
     * True, if the bot is allowed to edit administrator privileges of that user
     */
    val canBeEdited: Boolean? = null,
    /**
     * Optional. Administrators only.
     * True, if the administrator can post in the channel; channels only
     */
    val canPostMessages: Boolean? = null,
    /**
     * Optional. Administrators only.
     * True, if the administrator can edit messages of other users and can pin messages; channels only
     */
    val canEditMessages: Boolean? = null,
    /**
     * Optional. Administrators only.
     * True, if the administrator can delete messages of other users
     */
    val canDeleteMessages: Boolean? = null,
    /**
     * Optional. Administrators only. True,
     * if the administrator can restrict, ban or unban chat members
     */
    val canRestrictMembers: Boolean? = null,
    /**
     * Optional. Administrators only. True,
     * if the administrator can add new administrators with a subset of their own privileges or
     * demote administrators that he has promoted, directly or indirectly
     * (promoted by administrators that were appointed by the user)
     */
    val canPromoteMembers: Boolean? = null,
    /**
     * Optional. Administrators and restricted only.
     * True, if the user is allowed to change the chat title, photo and other settings
     */
    val canChangeInfo: Boolean? = null,
    /**
     * Optional. Administrators and restricted only.
     * True, if the user is allowed to invite new users to the chat
     */
    val canInviteUsers: Boolean? = null,
    /**
     * Optional. Administrators and restricted only.
     * True, if the user is allowed to pin messages; groups and supergroups only
     */
    val canPinMessages: Boolean? = null,
    /**
     * Optional. Restricted only.
     * True, if the user is a member of the chat at the moment of the request
     */
    val isMember: Boolean? = null,
    /**
     * Optional. Restricted only.
     * True, if the user is allowed to send text messages, contacts, locations and venues
     */
    val canSendMessages: Boolean? = null,
    /**
     * Optional. Restricted only.
     * True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes
     */
    val canSendMediaMessages: Boolean? = null,
    /**
     * Optional. Restricted only.
     * True, if the user is allowed to send polls
     */
    val canSendPolls: Boolean? = null,
    /**
     * Optional. Restricted only.
     * True, if the user is allowed to send animations, games, stickers and use inline bots
     */
    val canSendOtherMessages: Boolean? = null,
    /**
     * Optional. Restricted only.
     * True, if the user is allowed to add web page previews to their messages
     */
    val canAddWebPagePreviews: Boolean? = null
) : TelegramObject
