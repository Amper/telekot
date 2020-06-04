package org.marshalov.telekot

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import org.marshalov.telekot.client.BotApiClient
import org.marshalov.telekot.server.BotServer
import org.marshalov.telekot.server.testing.TestBotServer

class ClientCommonApiTests : StringSpec({
    runBlocking {
        val server: BotServer = TestBotServer().run()
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
