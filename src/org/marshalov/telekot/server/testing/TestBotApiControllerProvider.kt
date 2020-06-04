package org.marshalov.telekot.server.testing

import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import org.marshalov.telekot.server.ApiController
import org.marshalov.telekot.server.ApiControllerProvider
import org.marshalov.telekot.server.BotManager
import org.marshalov.telekot.server.dao.UsersDao
import org.marshalov.telekot.server.testing.controllers.TestCommonBotApiController
import org.marshalov.telekot.server.testing.controllers.TestUpdatesBotApiController
import org.marshalov.telekot.telegram.api.CommonBotApi
import org.marshalov.telekot.telegram.api.TelegramApi
import org.marshalov.telekot.telegram.api.UpdatesBotApi

/**
 *
 */
class TestBotApiControllerProvider(
    private val botManager: BotManager,
    private val usersDao: UsersDao
) : ApiControllerProvider {
    override val supportedApiControllerClasses: List<KClass<out TelegramApi>> = listOf(
        CommonBotApi::class,
        UpdatesBotApi::class
    )

    override fun <T : TelegramApi> getApiController(token: String, apiControllerClass: KClass<out T>): T =
        when (apiControllerClass) {
            CommonBotApi::class -> this.getApiController<CommonBotApi, TestCommonBotApiController>(token)
            UpdatesBotApi::class -> this.getApiController<UpdatesBotApi, TestUpdatesBotApiController>(token)
            else -> throw RuntimeException("TODO")
        }.apply {
            setApiToken(token)
            setBotManager(botManager)
            setUsersDao(usersDao)
        } as T

    private inline fun <reified T : TelegramApi, reified C : ApiController> getApiController(token: String): ApiController =
        controllers.getOrPut(T::class to token) {
            C::class.createInstance()
        }

    // @TODO: LRU/LFU-cache
    private val controllers: MutableMap<Pair<KClass<out TelegramApi>, String>, ApiController> =
        mutableMapOf()
}
