package vision.alter.telekot.server.testing

import com.google.gson.FieldNamingPolicy
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.ApplicationEngine
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.text.DateFormat
import kotlin.reflect.KParameter
import kotlin.reflect.KVisibility
import kotlin.reflect.full.callSuspendBy
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.instanceParameter
import mu.KotlinLogging
import vision.alter.telekot.server.ApiControllerProvider
import vision.alter.telekot.server.BotManager
import vision.alter.telekot.server.BotServer
import vision.alter.telekot.server.dao.UsersDao
import vision.alter.telekot.server.exceptions.InvalidTokenError
import vision.alter.telekot.server.extensions.respond

/**
 *
 */
class TestBotServer(
    private val dao: UsersDao = TestUsersDao(),
    override val botManager: BotManager = TestBotManager(
        dao
    ),
    override val apiControllerProvider: ApiControllerProvider = TestBotApiControllerProvider(
        botManager,
        dao
    )
) : BotServer {

    override val apiUrl: String
        get() = "http://$host:$port/api"

    override fun run(
        port: Int,
        host: String
    ): BotServer =
        synchronized(this) {
            this.host = host
            this.port = port
            when (server) {
                null -> createServer(port, host).start()
                else -> throw IllegalStateException("TODO")
            }
            return this
        }

    override fun stop(
        gracePeriodMillis: Long,
        timeoutMillis: Long
    ) =
        synchronized(this) {
            server
                ?.stop(gracePeriodMillis, timeoutMillis)
                ?: throw IllegalStateException("TODO")
            this.host = null
            this.port = null
        }

    // ------------------------------------------------------------------------------------------------------------- //

    private var server: ApplicationEngine? = null
    private var host: String? = null
    private var port: Int? = null

    private fun createServer(
        port: Int,
        host: String
    ): ApplicationEngine {
        val result = embeddedServer(
            factory = Netty,
            port = port,
            host = host
        ) {
            install(ContentNegotiation) {
                gson {
                    setDateFormat(DateFormat.LONG)
                    setPrettyPrinting()
                    setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    disableHtmlEscaping()
                }
            }
            routing {
                apiControllerProvider
                    .supportedApiControllerClasses
                    .forEach { apiControllerClass ->
                        apiControllerClass
                            .declaredMemberFunctions
                            .filter { it.visibility == KVisibility.PUBLIC }
                            .forEach { method ->
                                post("/api/bot{token}/${method.name}") {
                                    val token = call.parameters["token"] ?: throw InvalidTokenError()
                                    if (!botManager.isTokenValid(token)) {
                                        throw InvalidTokenError()
                                    }
                                    val parameters: MutableMap<KParameter, Any?> = method.parameters
                                        .associateWith { p -> call.parameters[p.name ?: ""] }
                                        .toMutableMap()
                                    parameters[method.instanceParameter!!] =
                                        apiControllerProvider.getApiController(token, apiControllerClass)
                                    respond {
                                        method.callSuspendBy(parameters)
                                    }
                                }
                            }
                    }
            }
        }
        server = result
        return result
    }

    companion object {
        private val logger = KotlinLogging.logger { }
    }
}
