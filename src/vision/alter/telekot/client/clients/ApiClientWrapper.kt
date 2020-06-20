package vision.alter.telekot.client.clients

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import vision.alter.telekot.client.clients.ApiClientWrapper.Companion.DEFAULT_API_URL
import vision.alter.telekot.client.exceptions.TelegramApiError
import vision.alter.telekot.client.exceptions.TelegramApiNullResultError
import vision.alter.telekot.client.factories.HttpClientFactory
import vision.alter.telekot.telegram.model.Response

/**
 * Wrapper for making requests to Telegram API.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
 * @property client HTTP-client for api calling.
 * @property DEFAULT_API_URL Default URL of Telegram API Server.
 */
class ApiClientWrapper(
    private val apiToken: String,
    apiUrl: String? = null,
    client: HttpClient? = null
) {
    private val apiUrl: String = apiUrl ?: DEFAULT_API_URL
    val client = client ?: HttpClientFactory.createHttpClient()

    /**
     * Make request and get response of Telegram API method.
     * @param method Kotlin method with whose name matches the method in the Telegram API
     * @param parameters Map with parameters for method
     * @return response for this method
     */
    suspend inline fun <reified T : Any, reified R : Response<T>> getMethodResult(
        method: KFunction<T>,
        parameters: Map<String, Any?> = emptyMap()
    ): T =
        getMethodResult(
            methodName = method.name,
            parameters = parameters,
            resultClass = T::class,
            responseClass = R::class
        )

    /**
     * Make request and get response of Telegram API method.
     * @param methodName Method name in the Telegram API
     * @param resultClass Expected class of result for this method
     * @param parameters Map with parameters for method
     * @return response for this method
     */
    suspend inline fun <reified T : Any, reified R : Response<T>> getMethodResult(
        methodName: String,
        parameters: Map<String, Any?> = emptyMap(),
        resultClass: KClass<T>,
        responseClass: KClass<R>
    ): T =
        getResponseResult(
            methodName = methodName,
            response = getResponse(methodName, parameters, resultClass, responseClass)
        )

    /**
     * Get method Telegram API url by method name
     * @param method Telegram API method name
     * @return Telegram API method URL
     */
    fun getMethodUrl(method: String) =
        "$apiUrl/bot$apiToken/$method"

    /**
     * Get Common Telegram API response by method name and parameters.
     * @param methodName Name of method in Telegram API
     * @param parameters Map of parameters for method calling
     * @param resultClass Kotlin class of expected result (wrapped in response)
     * @param responseClass Kotlin class of response
     * @return Telegram API Response
     * @see vision.alter.telekot.telegram.model.Response
     */
    @SuppressWarnings("UNUSED_PARAMETER")
    suspend inline fun <reified T : Any, reified R : Response<T>> getResponse(
        methodName: String,
        parameters: Map<String, Any?> = emptyMap(),
        resultClass: KClass<T>,
        responseClass: KClass<R>
    ): R =
        client.post(getMethodUrl(methodName)) {
            contentType(ContentType.Application.Json)
            body = parameters
        }

    /**
     * Get wrapped result object by common Telegram API Response.
     * @param methodName Name of method in Telegram API
     * @param response Any common Telegram API response, wrapping result object
     * @return Result object from response
     */
    fun <T : Any, R : Response<T>> getResponseResult(
        methodName: String,
        response: R
    ): T =
        when {
            !response.ok ->
                throw TelegramApiError(
                    methodName,
                    response.errorCode,
                    response.description
                )
            response.result == null ->
                throw TelegramApiNullResultError(methodName)
            else ->
                response.result
        }

    companion object {
        const val DEFAULT_API_URL = "https://api.telegram.org"
    }
}
