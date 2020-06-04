package org.marshalov.telekot.core.updates

import java.util.concurrent.Executors
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.marshalov.telekot.client.BotApiClient

/**
 *
 */
@SuppressWarnings("GlobalCoroutineUsage")
open class LongPoolingUpdateProvider(
    apiClient: BotApiClient,
    private val batchSize: Long = 100,
    poolSize: Int = 4
) : AbstractUpdateProvider(apiClient) {

    override fun run() {
        synchronized(this) {
            active = true
            job = job ?: GlobalScope.launch {
                var lastOffset: Long? = null
                while (active && !Thread.currentThread().isInterrupted) {
                    val updates = apiClient.updatesApi.getUpdates(
                        offset = lastOffset,
                        limit = batchSize,
                        timeout = 1
                    )
                    withContext(handlersDispatcher) {
                        updates
                            .map { update ->
                                async(handlersDispatcher) {
                                    handlers.values.map { handler ->
                                        handler(update)
                                    }
                                }
                            }
                            .awaitAll()
                    }
                    lastOffset = updates.lastOrNull()?.updateId ?: lastOffset
                }
            }
        }
    }

    override fun stop() {
        synchronized(this) {
            runBlocking {
                active = false
                job?.cancelAndJoin()
            }
        }
    }

    @Volatile
    protected var active: Boolean = false
    protected var job: Job? = null
    protected val handlersDispatcher = Executors.newWorkStealingPool(poolSize).asCoroutineDispatcher()
}
