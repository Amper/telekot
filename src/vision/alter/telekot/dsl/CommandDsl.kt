package vision.alter.telekot.dsl

/**
 *
 */
@BotDslMarker
data class CommandDsl(
    internal val bot: BotDsl,
    val name: String,
    val description: String = "",
    val handler: suspend CommandDsl.(event: EventDsl) -> Unit
)
