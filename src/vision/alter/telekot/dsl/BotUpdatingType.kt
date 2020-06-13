package vision.alter.telekot.dsl

/**
 *
 */
sealed class BotUpdatingType

/**
 *
 */
data class LongPooling(
    val batchSize: Long = 100,
    val poolSize: Int = 4,
    val timeout: Long = 1
) : BotUpdatingType()

/**
 *
 */
object WebHook : BotUpdatingType()
