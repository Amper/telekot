package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.factories.ApiClientFactory
import org.marshalov.telekot.client.impl.PaymentsBotApiClientImpl
import org.marshalov.telekot.telegram.api.PaymentsBotApiClient

/**
 * Factory for creating of Payments Telegram Bot API Client.
 */
object PaymentsBotApiClientFactory :
    ApiClientFactory<PaymentsBotApiClient> {
    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): PaymentsBotApiClient =
        PaymentsBotApiClientImpl(apiToken, apiUrl, client)
}
