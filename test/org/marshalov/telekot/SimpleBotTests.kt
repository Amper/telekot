package org.marshalov.telekot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.core.bots.AbstractBot
import org.marshalov.telekot.core.UpdateProdiver
import org.marshalov.telekot.core.bots.LongPoolingBot
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

        val bot = LongPoolingBot(token, server.apiUrl) { update ->
            println("update id = ${update.updateId}")
        }

        bot.run()
        delay(5000)
        bot.stop()

        "check getMe" {
            true shouldBe true
        }
    }
})
