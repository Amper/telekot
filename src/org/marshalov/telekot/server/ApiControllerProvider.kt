package org.marshalov.telekot.server

import kotlin.reflect.KClass
import org.marshalov.telekot.telegram.api.TelegramApi

/**
 *
 */
interface ApiControllerProvider {
    /**
     *
     */
    val supportedApiControllerClasses: List<KClass<out TelegramApi>>

    /**
     *
     */
    fun <T : TelegramApi> getApiController(token: String, apiControllerClass: KClass<out T>): T
}
