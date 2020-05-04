package org.marshalov.telekot.client.model

import kotlinx.serialization.Serializable
import org.marshalov.telekot.client.model.games.Game
import org.marshalov.telekot.client.model.markers.TelegramObject
import org.marshalov.telekot.client.model.passport.PassportData
import org.marshalov.telekot.client.model.payments.Invoice
import org.marshalov.telekot.client.model.payments.SuccessfulPayment
import org.marshalov.telekot.client.model.stickers.Sticker

/**
 * This object represents a message (https://core.telegram.org/bots/api#message).
 */
@Serializable
data class Message(
    /**
     * 	Unique message identifier inside this chat
     */
    val messageId: Long = -1,
    /**
     * 	Optional. Sender, empty for messages sent to channels
     */
    val from: User = User(),
    /**
     * 	Date the message was sent in Unix time
     */
    val date: Int = -1,
    /**
     * 	Conversation the message belongs to
     */
    val chat: Chat = Chat(),
    /**
     * 	Optional. For forwarded messages, sender of the original message
     */
    val forwardFrom: User? = null,
    /**
     * 	Optional. For messages forwarded from channels, information about the original channel
     */
    val forwardFromChat: Chat? = null,
    /**
     * 	Optional. For messages forwarded from channels, identifier of the original message in the channel
     */
    val forwardFromMessageId: Long? = null,
    /**
     * 	Optional. For messages forwarded from channels, signature of the post author if present
     */
    val forwardSignature: String? = null,
    /**
     * 	Optional. Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
     */
    val forwardSenderName: String? = null,
    /**
     * 	Optional. For forwarded messages, date the original message was sent in Unix time
     */
    val forwardDate: Int? = null,
    /**
     * 	Optional. For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
     */
    val replyToMessage: Message? = null,
    /**
     * 	Optional. Date the message was last edited in Unix time
     */
    val editDate: Int? = null,
    /**
     * 	Optional. The unique identifier of a media message group this message belongs to
     */
    val mediaGroupId: String? = null,
    /**
     * 	Optional. Signature of the post author for messages in channels
     */
    val authorSignature: String? = null,
    /**
     * 	Optional. For text messages, the actual UTF-8 text of the message, 0-4096 characters
     */
    val text: String? = null,
    /**
     *  Optional. For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
     */
    val entities: List<MessageEntity>? = null,
    /**
     *  Optional. For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption
     */
    val captionEntities: List<MessageEntity>? = null,
    /**
     * 	Optional. Message is an audio file, information about the file
     */
    val audio: Audio? = null,
    /**
     * 	Optional. Message is a general file, information about the file
     */
    val document: Document? = null,
    /**
     * 	Optional. Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set
     */
    val animation: Animation? = null,
    /**
     * 	Optional. Message is a game, information about the game. More about games »
     */
    val game: Game? = null,
    /**
     *  Optional. Message is a photo, available sizes of the photo
     */
    val photo: List<PhotoSize>? = null,
    /**
     * 	Optional. Message is a sticker, information about the sticker
     */
    val sticker: Sticker? = null,
    /**
     * 	Optional. Message is a video, information about the video
     */
    val video: Video? = null,
    /**
     * 	Optional. Message is a voice message, information about the file
     */
    val voice: Voice? = null,
    /**
     * 	Optional. Message is a video note, information about the video message
     */
    val videoNote: VideoNote? = null,
    /**
     * 	Optional. Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
     */
    val caption: String? = null,
    /**
     * 	Optional. Message is a shared contact, information about the contact
     */
    val contact: Contact? = null,
    /**
     * 	Optional. Message is a shared location, information about the location
     */
    val location: Location? = null,
    /**
     * 	Optional. Message is a venue, information about the venue
     */
    val venue: Venue? = null,
    /**
     * 	Optional. Message is a native poll, information about the poll
     */
    val poll: Poll? = null,
    /**
     * 	Optional. Message is a dice with random value from 1 to 6
     */
    val dice: Dice? = null,
    /**
     *  Optional. New members that were added to the group or supergroup and information about them (the bot itself may be one of these members)
     */
    val newChatMembers: List<User>? = null,
    /**
     * 	Optional. A member was removed from the group, information about them (this member may be the bot itself)
     */
    val leftChatMember: User? = null,
    /**
     * 	Optional. A chat title was changed to this value
     */
    val newChatTitle: String? = null,
    /**
     *  Optional. A chat photo was change to this value
     */
    val newChatPhoto: List<PhotoSize>? = null,
    /**
     * 	Optional. Service message: the chat photo was deleted
     */
    val deleteChatPhoto: Boolean? = null,
    /**
     * 	Optional. Service message: the group has been created
     */
    val groupChatCreated: Boolean? = null,
    /**
     * 	Optional. Service message: the supergroup has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
     */
    val supergroupChatCreated: Boolean? = null,
    /**
     * 	Optional. Service message: the channel has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
     */
    val channelChatCreated: Boolean? = null,
    /**
     * 	Optional. The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    val migrateToChatId: Long? = null,
    /**
     * 	Optional. The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    val migrateFromChatId: Long? = null,
    /**
     * 	Optional. Specified message was pinned. Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
     */
    val pinnedMessage: Message? = null,
    /**
     * 	Optional. Message is an invoice for a payment, information about the invoice. More about payments »
     */
    val invoice: Invoice? = null,
    /**
     * 	Optional. Message is a service message about a successful payment, information about the payment. More about payments »
     */
    val successfulPayment: SuccessfulPayment? = null,
    /**
     * 	Optional. The domain name of the website on which the user has logged in. More about Telegram Login »
     */
    val connectedWebsite: String? = null,
    /**
     * 	Optional. Telegram Passport data
     */
    val passportData: PassportData? = null,
    /**
     * 	Optional. Inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons.
     */
    val replyMarkup: InlineKeyboardMarkup? = null
) : TelegramObject
