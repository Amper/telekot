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
import org.marshalov.telekot.telegram.api.CommonBotApi
import org.marshalov.telekot.telegram.api.GamesBotApi
import org.marshalov.telekot.telegram.api.InlineBotApi
import org.marshalov.telekot.telegram.api.MessageEditingBotApi
import org.marshalov.telekot.telegram.api.PaymentsBotApi
import org.marshalov.telekot.telegram.api.StickersBotApi
import org.marshalov.telekot.telegram.api.UpdatesBotApi

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
        CommonBotApi::class to CommonBotApiClientFactory,
        MessageEditingBotApi::class to MessageEditingBotApiClientFactory,
        InlineBotApi::class to InlineBotApiClientFactory,
        UpdatesBotApi::class to UpdatesBotApiClientFactory,
        PaymentsBotApi::class to PaymentsBotApiClientFactory,
        StickersBotApi::class to StickersBotApiClientFactory,
        GamesBotApi::class to GamesBotApiClientFactory
    )
}
