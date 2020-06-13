package vision.alter.telekot

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import vision.alter.telekot.client.BotApiClient
import vision.alter.telekot.client.invoke
import vision.alter.telekot.server.BotServer
import vision.alter.telekot.server.testing.TestBotServer

class ClientCommonApiTests : StringSpec({
    runBlocking {
        val server: BotServer = TestBotServer()
            .run()
        val token = server.botManager.createBot(
            owner = "marshalov",
            name = "testbot",
            username = "testbot"
        )
        val api = BotApiClient(token, apiUrl = server.apiUrl).commonApi

        "check getMe" {
            val user = api.getMe()
            user.isBot shouldBe true
            user.username shouldBe "testbot"
        }
    }
})
