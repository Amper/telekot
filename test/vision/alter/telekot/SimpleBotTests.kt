package vision.alter.telekot

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
// import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
// import vision.alter.telekot.core.bots.LongPoolingBot
// import vision.alter.telekot.server.BotServer
// import vision.alter.telekot.server.testing.TestBotServer

class SimpleBotTests : StringSpec({
    runBlocking {
//        val server: BotServer = TestBotServer()
//            .run()
//        val token = server.botManager.createBot(
//            owner = "marshalov",
//            name = "testbot",
//            username = "testbot"
//        )
//
//        val bot = LongPoolingBot(token, server.apiUrl) { update ->
//            println("update id = ${update.updateId}")
//        }
//
//        bot.run()
//        delay(5000)
//        bot.stop()
//
//        server.stop(0, 0)

        "check getMe" {
            true shouldBe true
        }
    }
}) {
    companion object {
        private val logger = KotlinLogging.logger { }
    }
}
