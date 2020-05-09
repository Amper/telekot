package org.marshalov.telekot.client.factories

import io.ktor.client.HttpClient
import kotlin.reflect.full.isSubclassOf
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.client.factories.concrete.CommonBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.GamesBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.InlineBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.MessageEditingBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.PaymentsBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.SimpleBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.StickersBotApiClientFactory
import org.marshalov.telekot.client.factories.concrete.UpdatesBotApiClientFactory
import org.marshalov.telekot.telegram.api.CommonBotApiClient
import org.marshalov.telekot.telegram.api.GamesBotApiClient
import org.marshalov.telekot.telegram.api.InlineBotApiClient
import org.marshalov.telekot.telegram.api.MessageEditingBotApiClient
import org.marshalov.telekot.telegram.api.PaymentsBotApiClient
import org.marshalov.telekot.telegram.api.StickersBotApiClient
import org.marshalov.telekot.telegram.api.UpdatesBotApiClient

/**
 * Universal factory for creating of any Telegram Bot API Client.
 */
// @TODO: ????!!!!
object BotApiClientFactory {
    inline fun <reified T> createApiClient(
        apiToken: String,
        apiUrl: String?,
        client: HttpClient?
    ): T =
        factoriesMapping.entries
            .firstOrNull { T::class.isSubclassOf(it.key) }
            ?.value
            ?.createApiClient(apiToken, apiUrl, client) as? T
            ?: throw IllegalArgumentException("...")

    val factoriesMapping = mapOf(
        BotApiClient::class to SimpleBotApiClientFactory,
        CommonBotApiClient::class to CommonBotApiClientFactory,
        MessageEditingBotApiClient::class to MessageEditingBotApiClientFactory,
        InlineBotApiClient::class to InlineBotApiClientFactory,
        UpdatesBotApiClient::class to UpdatesBotApiClientFactory,
        PaymentsBotApiClient::class to PaymentsBotApiClientFactory,
        StickersBotApiClient::class to StickersBotApiClientFactory,
        GamesBotApiClient::class to GamesBotApiClientFactory
    )
}
