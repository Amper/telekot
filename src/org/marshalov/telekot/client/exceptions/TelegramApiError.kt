package org.marshalov.telekot.client.exceptions

/**
 * Error returned in TgResponse when calling the Telegram API method.
 * @see org.marshalov.telekot.messengers.telegram.client.model.Response
 * @param method Method name from official Telegram Documentation: https://core.telegram.org/bots/api#available-methods
 * @param errorCode Error code from Telegram API response: https://core.telegram.org/bots/api#making-requests
 * @param message Description from Telegram API response: https://core.telegram.org/bots/api#making-requests
 */
class TelegramApiError(
    val method: String,
    val errorCode: Int?,
    message: String?
) :
    RuntimeException("Telegram API error `$errorCode` for method `$method`: $message")
