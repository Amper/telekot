package org.marshalov.telekot.client.clients

import io.ktor.client.HttpClient
import org.marshalov.telekot.telegram.api.PaymentsBotApi
import org.marshalov.telekot.telegram.model.InlineKeyboardMarkup
import org.marshalov.telekot.telegram.model.Message
import org.marshalov.telekot.telegram.model.payments.LabeledPrice
import org.marshalov.telekot.telegram.model.payments.ShippingOption

/**
 * Payments Telegram Bot API implementation.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 */
class PaymentsBotApiClient(
    apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) : PaymentsBotApi {

    override suspend fun sendInvoice(
        chatId: Long,
        title: String,
        description: String,
        payload: String,
        providerToken: String,
        startParameter: String,
        currency: String,
        prices: List<LabeledPrice>,
        providerData: String?,
        photoUrl: String?,
        photoSize: Int?,
        photoWidth: Int?,
        photoHeight: Int?,
        needName: Boolean?,
        needPhoneNumber: Boolean?,
        needEmail: Boolean?,
        needShippingAddress: Boolean?,
        sendPhoneNumberToProvider: Boolean?,
        sendEmailToProvider: Boolean?,
        isFlexible: Boolean?,
        disableNotification: Boolean?,
        replyToMessageId: Int?,
        replyMarkup: InlineKeyboardMarkup?
    ): Message =
        api.getMethodResult(
            ::sendInvoice, mapOf(
                "chat_id" to chatId,
                "title" to title,
                "description" to description,
                "payload" to payload,
                "provider_token" to providerToken,
                "start_parameter" to startParameter,
                "currency" to currency,
                "prices" to prices,
                "provider_data" to providerData,
                "photo_url" to photoUrl,
                "photo_size" to photoSize,
                "photo_width" to photoWidth,
                "photo_height" to photoHeight,
                "need_name" to needName,
                "need_phone_number" to needPhoneNumber,
                "need_email" to needEmail,
                "need_shipping_address" to needShippingAddress,
                "send_phone_number_to_provider" to sendPhoneNumberToProvider,
                "send_email_to_provider" to sendEmailToProvider,
                "is_flexible" to isFlexible,
                "disable_notification" to disableNotification,
                "reply_to_message_id" to replyToMessageId,
                "reply_markup" to replyMarkup
            )
        )

    override suspend fun answerShippingQuery(
        shippingQueryId: String,
        ok: Boolean,
        shippingOptions: List<ShippingOption>?,
        errorMessage: String?
    ): Boolean =
        api.getMethodResult(
            ::answerShippingQuery, mapOf(
                "shipping_query_id" to shippingQueryId,
                "ok" to ok,
                "shipping_options" to shippingOptions,
                "error_message" to errorMessage
            )
        )

    override suspend fun answerPreCheckoutQuery(
        preCheckoutQueryId: String,
        ok: Boolean,
        errorMessage: String?
    ): Boolean =
        api.getMethodResult(
            ::answerPreCheckoutQuery, mapOf(
                "pre_checkout_query_id" to preCheckoutQueryId,
                "ok" to ok,
                "error_message" to errorMessage
            )
        )

    // ------------------------------------------------------------------------------------------------------------- //

    private val api = ApiClientWrapper(apiToken, apiUrl, client)
}
