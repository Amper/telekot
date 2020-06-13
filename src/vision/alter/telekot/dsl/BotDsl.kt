package vision.alter.telekot.dsl

import vision.alter.telekot.client.BotApiClient

/**
 *
 */
@BotDslMarker
data class BotDsl(
    var updatingType: BotUpdatingType = LongPooling(),
    var apiToken: String? = null,
    var apiUrl: String? = null
) {
    internal val commands: MutableSet<CommandDsl> = HashSet()
    internal var unknownCommandHandler: suspend (event: EventDsl) -> Unit = {}
    internal lateinit var apiClient: BotApiClient

    /**
     *
     */
    fun command(name: String, description: String = "", handler: suspend CommandDsl.(event: EventDsl) -> Unit) =
        CommandDsl(this, name, description, handler).let(commands::add)

    /**
     *
     */
    fun unknownCommand(handler: suspend (event: EventDsl) -> Unit) {
        unknownCommandHandler = handler
    }
}
