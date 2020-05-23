package org.marshalov.telekot

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import org.marshalov.telekot.client.BotApiClient

class ClientCommonApiTestsOnRealServer : StringSpec({
    runBlocking {
        "check nothing" {
            "check" shouldBe "check"
        }

        val token = System.getenv("TEST_TELEGRAM_BOT_TOKEN") ?: return@runBlocking
        val api = BotApiClient(token).commonApi

        "check getMe" {
            val user = api.getMe()
            println(user)

            user.isBot shouldBe true
            user.username shouldBe "aml_test_bot"
        }

        "check getChat" {
            val chat = api.getChat("@telegram")
            chat.username shouldBe "telegram"
        }
    }
})
