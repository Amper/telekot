package vision.alter.telekot.server

/**
 * Telegram Bot API Server.
 * @property apiUrl API URL of this server
 * @property botManager Bot Manager for this server (BotManager similar in functionality to @BotFather in Telegram)
 * @property apiControllerProvider Provider of controllers for specified token.
 */
interface BotServer {
    /**
     * API URL of this server
     */
    val apiUrl: String

    /**
     * Bot Manager for this server (BotManager similar in functionality to @BotFather in Telegram)
     */
    val botManager: BotManager

    /**
     * Provider of controllers for specified token.
     */
    val apiControllerProvider: ApiControllerProvider

    /**
     * Run Telegram Bot API Server
     * @param host hostname for server runnning
     * @param port port for server running
     */
    fun run(
        port: Int = DEFAULT_PORT,
        host: String = DEFAULT_HOST
    ): BotServer

    /**
     * Stop this running Telegram Bot API Server.
     * @param gracePeriodMillis the maximum amount of time for activity to cool down
     * @param timeoutMillis the maximum amount of time to wait until server stops gracefully
     */
    fun stop(
        gracePeriodMillis: Long,
        timeoutMillis: Long
    )

    companion object {
        /**
         * Default port for running Bot API Server
         */
        const val DEFAULT_PORT = 9000
        /**
         * Default host for running Bot API Server
         */
        const val DEFAULT_HOST = "0.0.0.0"
    }
}
