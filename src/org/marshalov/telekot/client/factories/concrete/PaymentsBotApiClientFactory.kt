package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.clients.PaymentsBotApiClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.telegram.api.PaymentsBotApi

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
