package vision.alter.telekot.telegram.api

import vision.alter.telekot.telegram.model.InlineKeyboardMarkup
import vision.alter.telekot.telegram.model.Message
import vision.alter.telekot.telegram.model.payments.LabeledPrice
import vision.alter.telekot.telegram.model.payments.ShippingOption

/**
 * Interface for Payments Telegram Bot API (https://core.telegram.org/bots/api#payments).
 */
@Suppress("LongParameterList")
interface PaymentsBotApi : TelegramApi {
    /**
     * Use this method to send invoices (https://core.telegram.org/bots/api#sendinvoice).
     * @param chatId Unique identifier for the target private chat
     * @param title Product name, 1-32 characters
     * @param description Product description, 1-255 characters
     * @param payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
     * @param providerToken Payments provider token, obtained via Botfather
     * @param startParameter Unique deep-linking parameter that can be used to generate this invoice when used as a start parameter
     * @param currency Three-letter ISO 4217 currency code, see more on currencies
     * @param prices Price breakdown, a JSON-serialized list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
     * @param providerData JSON-encoded data about the invoice, which will be shared with the payment provider. A detailed description of required fields should be provided by the payment provider.
     * @param photoUrl URL of the product photo for the invoice. Can be a photo of the goods or a marketing image for a service. People like it better when they see what they are paying for.
     * @param photoSize Photo size
     * @param photoWidth Photo width
     * @param photoHeight Photo height
     * @param needName Pass True, if you require the user's full name to complete the order
     * @param needPhoneNumber Pass True, if you require the user's phone number to complete the order
     * @param needEmail Pass True, if you require the user's email address to complete the order
     * @param needShippingAddress Pass True, if you require the user's shipping address to complete the order
     * @param sendPhoneNumberToProvider Pass True, if user's phone number should be sent to provider
     * @param sendEmailToProvider Pass True, if user's email address should be sent to provider
     * @param isFlexible Pass True, if the final price depends on the shipping method
     * @param disableNotification Sends the message silently. Users will receive a notification with no sound.
     * @param replyToMessageId If the message is a reply, ID of the original message
     * @param replyMarkup A JSON-serialized object for an inline keyboard. If empty, one 'Pay total price' button will be shown. If not empty, the first button must be a Pay button.
     * @return send Message
     */
    suspend fun sendInvoice(
        chatId: Long,
        title: String,
        description: String,
        payload: String,
        providerToken: String,
        startParameter: String,
        currency: String,
        prices: List<LabeledPrice>,
        providerData: String? = null,
        photoUrl: String? = null,
        photoSize: Int? = null,
        photoWidth: Int? = null,
        photoHeight: Int? = null,
        needName: Boolean? = null,
        needPhoneNumber: Boolean? = null,
        needEmail: Boolean? = null,
        needShippingAddress: Boolean? = null,
        sendPhoneNumberToProvider: Boolean? = null,
        sendEmailToProvider: Boolean? = null,
        isFlexible: Boolean? = null,
        disableNotification: Boolean? = null,
        replyToMessageId: Int? = null,
        replyMarkup: InlineKeyboardMarkup? = null
    ): Message

    /**
     * If you sent an invoice requesting a shipping address and the parameter is_flexible was specified,
     * the Bot API will send an Update with a shipping_query field to the bot.
     * (https://core.telegram.org/bots/api#answershippingquery)
     * Use this method to reply to shipping queries.
     * @param shippingQueryId Unique identifier for the query to be answered
     * @param ok Specify True if delivery to the specified address is possible and False if there are any problems (for example, if delivery to the specified address is not possible)
     * @param shippingOptions Required if ok is True. A JSON-serialized array of available shipping options.
     * @param errorMessage Required if ok is False. Error message in human readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable'). Telegram will display this message to the user.
     * @return True, on success.
     */
    suspend fun answerShippingQuery(
        shippingQueryId: String,
        ok: Boolean,
        shippingOptions: List<ShippingOption>? = null,
        errorMessage: String? = null
    ): Boolean

    /**
     * Once the user has confirmed their payment and shipping details,
     * the Bot API sends the final confirmation in the form of an Update with the field pre_checkout_query.
     * (https://core.telegram.org/bots/api#answerprecheckoutquery)
     * Use this method to respond to such pre-checkout queries.
     * Note: The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.
     * @param preCheckoutQueryId Unique identifier for the query to be answered
     * @param ok Specify True if everything is alright (goods are available, etc.) and the bot is ready to proceed with the order. Use False if there are any problems.
     * @param errorMessage Required if ok is False. Error message in human readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
     * @return True, on success.
     */
    suspend fun answerPreCheckoutQuery(
        preCheckoutQueryId: String,
        ok: Boolean,
        errorMessage: String? = null
    ): Boolean
}
