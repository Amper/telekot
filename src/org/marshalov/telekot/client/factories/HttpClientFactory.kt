package org.marshalov.telekot.client.factories

import com.google.gson.FieldNamingPolicy
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.http.ContentType
import io.ktor.http.contentType
import java.text.DateFormat

/**
 * Factory for creating of HTTP Clients for Telegram API.
 */
object HttpClientFactory {
    fun createHttpClient(): HttpClient {
        val result = HttpClient(Apache) {
            defaultRequest { contentType(ContentType.Application.Json) }
            install(JsonFeature) {
                serializer = GsonSerializer {
                    setDateFormat(DateFormat.LONG)
                    setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    disableHtmlEscaping()
                }
            }
        }
        return result
    }
}
