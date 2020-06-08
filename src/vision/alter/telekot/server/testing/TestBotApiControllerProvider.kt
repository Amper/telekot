package vision.alter.telekot.server.testing

import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import vision.alter.telekot.server.ApiController
import vision.alter.telekot.server.ApiControllerProvider
import vision.alter.telekot.server.BotManager
import vision.alter.telekot.server.dao.UsersDao
import vision.alter.telekot.server.testing.controllers.TestCommonBotApiController
import vision.alter.telekot.server.testing.controllers.TestUpdatesBotApiController
import vision.alter.telekot.telegram.api.CommonBotApi
import vision.alter.telekot.telegram.api.TelegramApi
import vision.alter.telekot.telegram.api.UpdatesBotApi

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

    @Suppress("UNCHECKED_CAST")
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
