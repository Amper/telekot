package org.marshalov.telekot.telegram.model.updates

import kotlinx.serialization.Serializable
import org.marshalov.telekot.telegram.model.markers.TelegramObject

/**
 * Contains information about the current status of a webhook (https://core.telegram.org/bots/api#webhookinfo).
 */
@Serializable
data class WebhookInfo(
    /**
     * Webhook URL, may be empty if webhook is not set up
     */
    val url: String = "",
    /**
     * True, if a custom certificate was provided for webhook certificate checks
     */
    val hasCustomCertificate: Boolean = false,
    /**
     * Number of updates awaiting delivery
     */
    val pendingUpdateCount: Int = 0,
    /**
     * Optional. Unix time for the most recent error that happened when trying to deliver an update via webhook
     */
    val lastErrorDate: Int = -1,
    /**
     * Optional. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
     */
    val lastErrorMessage: String? = null,
    /**
     * Optional. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
     */
    val maxConnections: Int? = null,
    /**
     * Optional. A list of update types the bot is subscribed to. Defaults to all update types
     */
    // @TODO: enum
    val allowedUpdates: List<String>? = null
) : TelegramObject
