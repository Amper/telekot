package org.marshalov.telekot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.StringSpec
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.core.Bot
import org.marshalov.telekot.core.UpdateProdiver
import org.marshalov.telekot.core.updates.LongPoolingUpdateProvider
import org.marshalov.telekot.server.BotServer
import org.marshalov.telekot.server.testing.TestBotServer
import org.marshalov.telekot.telegram.model.updates.Update

@AnnotationSpec.Ignore
class SimpleBotTests : StringSpec({
    runBlocking {
        val server: BotServer = TestBotServer().run()
        val token = server.botManager.createBot(
            owner = "marshalov",
            name = "testbot",
            username = "testbot"
        )

        class SimpleBot(
            apiToken: String,
            apiUrl: String,
            override val apiClient: BotApiClient = BotApiClient(apiToken, apiUrl),
            override val updateProvider: UpdateProdiver = LongPoolingUpdateProvider(apiClient)
        ) : Bot {
            override suspend fun onUpdate(update: Update) {
                TODO()
            }
        }

        val bot = SimpleBot(
            apiToken = token,
            apiUrl = server.apiUrl
        )

        bot.run()

        delay(5000)

        bot.stop()

        delay(5000)

        "check getMe" {
            bot.run()
        }
    }
})
