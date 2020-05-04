package org.marshalov.telekot.client.api

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import org.marshalov.telekot.client.exceptions.TelegramApiError
import org.marshalov.telekot.client.factories.HttpClientFactory
import org.marshalov.telekot.client.model.Response
import kotlin.reflect.KClass
import kotlin.reflect.KFunction

/**
 * Wrapper for making requests to Telegram API.
 * @param apiToken Unique authentification token (https://core.telegram.org/bots/api#authorizing-your-bot)
 * @param apiUrl Root URL of Telegram API (https://api.telegram.org)
 * @param client KTOR HTTP Client instance
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
            method = methodName,
            response = getResponse(methodName, parameters, resultClass, responseClass)
        )

    fun getMethodUrl(method: String) =
        "$apiUrl/bot$apiToken/$method"

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

    fun <T : Any, R : Response<T>> getResponseResult(
        method: String,
        response: R
    ): T =
        when {
            !response.ok ->
                throw TelegramApiError(
                    method,
                    response.errorCode,
                    response.description
                )
            // @TODO: Create class for this exception
            response.result == null ->
                throw RuntimeException("An null value was returned for result in the method `getMe` in the Telegram API")
            else ->
                response.result
        }

    companion object {
        const val DEFAULT_API_URL = "https://api.telegram.org"
    }

}
