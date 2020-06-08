package vision.alter.telekot.server.exceptions

/**
 * Error returned in Bot API Server, when request contains an invalid or missing token.
 */
class InvalidTokenError : RuntimeException("Given bot token is invalid!")
