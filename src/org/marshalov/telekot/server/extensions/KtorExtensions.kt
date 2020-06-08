package org.marshalov.telekot.server.extensions

import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.util.pipeline.PipelineContext
import org.marshalov.telekot.telegram.model.Response

/**
 * Send Responce for block in routing.
 */
suspend inline fun <reified T : Any> PipelineContext<Unit, ApplicationCall>.respond(block: () -> T?) {
    call.respond(
        try {
            Response.ok(block())
        } catch (e: Throwable) {
            Response.fail(e.message)
        }
    )
}
