package vision.alter.telekot.dsl

import vision.alter.telekot.telegram.model.Message

/**
 *
 */
@BotDslMarker
data class ContextDsl(
    internal val event: EventDsl,
    val history: List<Message>
)
