package org.marshalov.telekot.client.api

import org.marshalov.telekot.client.model.updates.Update
import org.marshalov.telekot.client.model.updates.WebhookInfo

/**
 * Interface for Updates Telegram Bot API (https://core.telegram.org/bots/api#getting-updates).
 */
interface UpdatesBotApiClient {

    /**
     * Use this method to receive incoming updates using long polling (wiki). An Array of Update objects is returned.
     * (https://core.telegram.org/bots/api#getupdates)
     * @param offset Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as getUpdates is called with an offset higher than its update_id. The negative offset can be specified to retrieve updates starting from -offset update from the end of the updates queue. All previous updates will forgotten.
     * @param limit Limits the number of updates to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     * @param timeout Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
     * @param allowedUpdates A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See Update for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used. Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
     * @return List of Update objects
     */
    suspend fun getUpdates(
        offset: Int? = null,
        limit: Int? = null,
        timeout: Int? = null,
        // @TODO: enum
        allowedUpdates: List<String>? = null
    ): List<Update>

    /**
     * Use this method to specify a url and receive incoming updates via an outgoing webhook.
     * (https://core.telegram.org/bots/api#setwebhook)
     * Whenever there is an update for the bot, we will send an HTTPS POST request to the specified url,
     * containing a JSON-serialized Update.
     * In case of an unsuccessful request, we will give up after a reasonable amount of attempts.
     * If you'd like to make sure that the Webhook request comes from Telegram,
     * we recommend using a secret path in the URL, e.g. https://www.example.com/<token>.
     * Since nobody else knows your bot‘s token, you can be pretty sure it’s us.
     * @param url HTTPS url to send updates to. Use an empty string to remove webhook integration
     * @param certificate Upload your public key certificate so that the root certificate in use can be checked. See our self-signed guide for details.
     * @param maxConnections Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to 40. Use lower values to limit the load on your bot‘s server, and higher values to increase your bot’s throughput.
     * @param allowedUpdates A JSON-serialized list of the update types you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See Update for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used. Please note that this parameter doesn't affect updates created before the call to the setWebhook, so unwanted updates may be received for a short period of time.
     * @return True on success
     */
    suspend fun setWebhook(
        url: String,
        // @TODO: ???
        certificate: String? = null,
        maxConnections: Int? = null,
        // @TODO: enum
        allowedUpdates: List<String>? = null
    ): Boolean

    /**
     * Use this method to remove webhook integration if you decide to switch back to getUpdates. Requires no parameters.
     * (https://core.telegram.org/bots/api#deletewebhook)
     * @return True on success.
     */
    suspend fun deleteWebhook(): Boolean

    /**
     * Use this method to get current webhook status. Requires no parameters. On success, returns a WebhookInfo object.
     * If the bot is using getUpdates, will return an object with the url field empty.
     * (https://core.telegram.org/bots/api#getwebhookinfo)
     * @return WebhookInfo object
     */
    suspend fun getWebhookInfo(): WebhookInfo

}
