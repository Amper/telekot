package vision.alter.telekot.server.testing

import kotlinx.atomicfu.atomic

/**
 * Simple generator of unique identifiers (within this instance of service).
 */
object IdGenerator {
    private val id = atomic(0L)

    /**
     * Generate next unique identifier (within this instance of service).
     * @return Long - unique indentifier
     */
    fun getNextId(): Long =
        id.incrementAndGet()
}
