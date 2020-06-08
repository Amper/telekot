package vision.alter.telekot.server.testing.controllers

import vision.alter.telekot.telegram.api.UpdatesBotApi
import vision.alter.telekot.telegram.model.updates.Update
import vision.alter.telekot.telegram.model.updates.WebhookInfo

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
