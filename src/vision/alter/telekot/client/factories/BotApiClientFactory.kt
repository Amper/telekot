package vision.alter.telekot.client.factories

import io.ktor.client.HttpClient
import kotlin.reflect.full.isSubclassOf
import vision.alter.telekot.client.BotApiClient
import vision.alter.telekot.client.factories.concrete.CommonBotApiClientFactory
import vision.alter.telekot.client.factories.concrete.GamesBotApiClientFactory
import vision.alter.telekot.client.factories.concrete.InlineBotApiClientFactory
import vision.alter.telekot.client.factories.concrete.MessageEditingBotApiClientFactory
import vision.alter.telekot.client.factories.concrete.PaymentsBotApiClientFactory
import vision.alter.telekot.client.factories.concrete.SimpleBotApiClientFactory
import vision.alter.telekot.client.factories.concrete.StickersBotApiClientFactory
import vision.alter.telekot.client.factories.concrete.UpdatesBotApiClientFactory
import vision.alter.telekot.telegram.api.CommonBotApi
import vision.alter.telekot.telegram.api.GamesBotApi
import vision.alter.telekot.telegram.api.InlineBotApi
import vision.alter.telekot.telegram.api.MessageEditingBotApi
import vision.alter.telekot.telegram.api.PaymentsBotApi
import vision.alter.telekot.telegram.api.StickersBotApi
import vision.alter.telekot.telegram.api.UpdatesBotApi

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
