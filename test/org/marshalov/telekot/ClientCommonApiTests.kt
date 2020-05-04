package org.marshalov.telekot

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import org.marshalov.telekot.client.BotApiClient

class ClientCommonApiTests : StringSpec({
    runBlocking {

        val api = BotApiClient(System.getenv("TEST_TELEGRAM_BOT_TOKEN")).commonApi

        "check getMe" {
            val user = api.getMe()
            user.isBot shouldBe true
            user.username shouldBe "aml_test_bot"
        }

        "check getChat" {
            val chat = api.getChat("@telegram")
            chat.username shouldBe "telegram"
        }

    }
})
