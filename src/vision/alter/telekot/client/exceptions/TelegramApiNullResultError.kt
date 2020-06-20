package vision.alter.telekot.client.exceptions

/**
 * Error returned in Response when value was returned for result.
 * @see vision.alter.telekot.client.clients.ApiClientWrapper
 * @param method Method name from official Telegram Documentation: https://core.telegram.org/bots/api#available-methods
 */
class TelegramApiNullResultError(
    val method: String
) :
    RuntimeException("An null value was returned for result in the method `$method` in the Telegram API")
