package vision.alter.telekot

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import vision.alter.telekot.client.BotApiClient
import vision.alter.telekot.core.bots.AbstractBot
import vision.alter.telekot.core.UpdateProdiver
import vision.alter.telekot.core.bots.LongPoolingBot
import vision.alter.telekot.core.updates.LongPoolingUpdateProvider
import vision.alter.telekot.server.BotServer
import vision.alter.telekot.server.testing.TestBotServer
import vision.alter.telekot.telegram.model.updates.Update

@AnnotationSpec.Ignore
class SimpleBotTests : StringSpec({
    runBlocking {
        val server: BotServer = TestBotServer()
            .run()
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
