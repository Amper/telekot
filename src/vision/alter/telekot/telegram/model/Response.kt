package vision.alter.telekot.telegram.model

import kotlinx.serialization.Serializable

/**
 * Structure with a response to requests to Telegram apps (https://core.telegram.org/bots/api#making-requests).
 */
@Serializable
data class Response<T : Any>(
    /**
     * Request result.
     * If ‘ok’ equals true, the request was successful, In case of an unsuccessful request, ‘ok’ equals false.
     */
    val ok: Boolean = false,
    /**
     * If ‘ok’ equals true, the request was successful and the result of the query can be found in the ‘result’ field.
     */
    val result: T? = null,
    /**
     * In case of an unsuccessful request, ‘ok’ equals false and the error is explained in the ‘description’.
     */
    val description: String? = null,
    /**
     * An Integer ‘error_code’ field is also returned, but its contents are subject to change in the future.
     */
    val errorCode: Int? = null,
    /**
     * Optional field ‘parameters’ for some errors, which can help to automatically handle the error.
     */
    val parameters: ResponseParameters? = null
) {
    companion object {
        /**
         * Create successful response.
         * @param result Reulst of response
         * @return Response wit `ok = true` and result.
         */
        @SuppressWarnings("FunctionMinLength")
        inline fun <reified T : Any> ok(
            result: T?
        ): Response<T> =
            Response(
                ok = true,
                result = result
            )

        /**
         * Create failed response.
         * @param description Error message.
         * @param errorCode Code of error.
         * @return Response with `ok = false`, description and errorCode.
         */
        inline fun <reified T : Any> fail(
            description: String? = null,
            errorCode: Int? = null
        ): Response<T> =
            Response(
                ok = false,
                description = description,
                errorCode = errorCode
            )
    }
}
