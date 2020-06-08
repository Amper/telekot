package org.marshalov.telekot.server.testing.controllers

import org.marshalov.telekot.telegram.api.UpdatesBotApi
import org.marshalov.telekot.telegram.model.updates.Update
import org.marshalov.telekot.telegram.model.updates.WebhookInfo

/**
 *
 */
@SuppressWarnings("StringLiteralDuplication")
class TestUpdatesBotApiController : UpdatesBotApi, AbstractTestBotApiController() {
    override suspend fun getUpdates(
        offset: Long?,
        limit: Long?,
        timeout: Long?,
        allowedUpdates: List<String>?
    ): List<Update> {
        return emptyList()
    }

    override suspend fun setWebhook(
        url: String,
        certificate: String?,
        maxConnections: Int?,
        allowedUpdates: List<String>?
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWebhook(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getWebhookInfo(): WebhookInfo {
        TODO("Not yet implemented")
    }
}
