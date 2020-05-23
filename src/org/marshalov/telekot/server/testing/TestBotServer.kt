package org.marshalov.telekot.server.testing

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
import org.marshalov.telekot.server.ApiControllerProvider
import org.marshalov.telekot.server.BotManager
import org.marshalov.telekot.server.BotServer
import org.marshalov.telekot.server.dao.BotsDao
import org.marshalov.telekot.server.exceptions.InvalidTokenError
import org.marshalov.telekot.server.extensions.respond

/**
 *
 */
class TestBotServer(
    private val dao: BotsDao = TestBotsDao(),
    override val botManager: BotManager = TestBotManager(dao),
    override val apiControllerProvider: ApiControllerProvider = TestBotApiControllerProvider(botManager)
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
