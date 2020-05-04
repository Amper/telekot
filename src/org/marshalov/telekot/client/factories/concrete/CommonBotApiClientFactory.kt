package org.marshalov.telekot.client.factories.concrete

import io.ktor.client.HttpClient
import org.marshalov.telekot.client.api.CommonBotApiClient
import org.marshalov.telekot.client.api.impl.CommonBotApiClientImpl
import org.marshalov.telekot.client.factories.ApiClientFactory

object CommonBotApiClientFactory :
    ApiClientFactory<CommonBotApiClient> {

    override fun createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): CommonBotApiClient =
        CommonBotApiClientImpl(apiToken, apiUrl, client)
}
