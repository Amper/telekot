package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable
import vision.alter.telekot.telegram.model.markers.TelegramObject

/**
 * This object represents a chat (https://core.telegram.org/bots/api#chat).
 */
@Serializable
data class Chat(
    /**
     * Unique identifier for this chat. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    val id: Long = -1,
    /**
     * Type of chat, can be either “private”, “group”, “supergroup” or “channel”
     */
    val type: String = "",
    /**
     * Optional. Title, for supergroups, channels and group chats
     */
    val title: String? = null,
    /**
     * Optional. Username, for private chats, supergroups and channels if available
     */
    val username: String? = null,
    /**
     * Optional. First name of the other party in a private chat
     */
    val firstName: String? = null,
    /**
     * Optional. Last name of the other party in a private chat
     */
    val lastName: String? = null,
    /**
     * Optional. Chat photo. Returned only in getChat.
     */
    val photo: ChatPhoto? = null,
    /**
     * Optional. Description, for groups, supergroups and channel chats. Returned only in getChat.
     */
    val description: String? = null,
    /**
     * Optional. Chat invite link, for groups, supergroups and channel chats. Each administrator in a chat generates their own invite links, so the bot must first generate the link using exportChatInviteLink. Returned only in getChat.
     */
    val inviteLink: String? = null,
    /**
     * Optional. Pinned message, for groups, supergroups and channels. Returned only in getChat.
     */
    val pinnedMessage: Message? = null,
    /**
     * Optional. Default chat member permissions, for groups and supergroups. Returned only in getChat.
     */
    val permissions: ChatPermissions? = null,
    /**
     * Optional. For supergroups, the minimum allowed delay between consecutive messages sent by each unpriviledged user. Returned only in getChat.
     */
    val slowModeDelay: Int? = null,
    /**
     * Optional. For supergroups, name of group sticker set. Returned only in getChat.
     */
    val stickerSetName: String? = null,
    /**
     * Optional. True, if the bot can change the group sticker set. Returned only in getChat.
     */
    val canSetStickerSet: Boolean? = null
) : TelegramObject
