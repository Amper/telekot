package vision.alter.telekot.server

import kotlin.reflect.KClass
import vision.alter.telekot.telegram.api.TelegramApi

/**
 * Provider of controllers for specified token.
 * @property supportedApiControllerClasses List of interfaces supported by this provider.
 */
interface ApiControllerProvider {
    /**
     * List of interfaces supported by this provider.
     */
    val supportedApiControllerClasses: List<KClass<out TelegramApi>>

    /**
     * Getting an instance of a controller of the specified class for the specified token.
     * @param token Telegram Bot API token.
     * @param apiControllerClass Controller interface.
     */
    fun <T : TelegramApi> getApiController(token: String, apiControllerClass: KClass<out T>): T
}
