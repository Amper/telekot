package vision.alter.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import vision.alter.telekot.client.clients.PaymentsBotApiClient
import vision.alter.telekot.client.factories.ApiClientFactory
import vision.alter.telekot.telegram.api.PaymentsBotApi

/**
 * Factory for creating of Payments Telegram Bot API Client.
 */
object PaymentsBotApiClientFactory :
    ApiClientFactory<PaymentsBotApi> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): PaymentsBotApi =
        PaymentsBotApiClient(apiToken, apiUrl, client)
}
