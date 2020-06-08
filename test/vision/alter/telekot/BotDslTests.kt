package vision.alter.telekot

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.runBlocking
import vision.alter.telekot.dsl.LongPooling
import vision.alter.telekot.dsl.bot

class BotDslTests : StringSpec({
    runBlocking {

        bot {
            apiToken = "sdcasdc"
            updatingType = LongPooling(batchSize = 100, timeout = 1)

            command("start") { event ->
                event.answer("Hello, ${event.user.username}")
            }

            command("history") { event ->
                event.answer("In chat ${event.chat.title} your last messages: ${event.context.history}")
            }

            unknownCommand { event ->
                event.answer("Unknown command: ${event.command.name}")
            }
        }

        "check getMe" {
            true shouldBe true
        }
    }
})
