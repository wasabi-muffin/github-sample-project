package jp.co.yumemi.android.code_check.data.core

import jp.co.yumemi.android.code_check.domain.core.DomainError

/**
 * Data exception
 *
 * Wrapper for remote and local [Throwable]s
 *
 * [Exception]s should be caught in the remote and local layer and thrown as [DataException]s to the domain layer
 */
sealed class DataException : Throwable() {
    abstract override val message: String?
    abstract override val cause: Throwable?

    /**
     * Unknown
     *
     * All non-mapped exceptions are classified as unknown
     */
    data class Unknown(
        override val message: String? = null,
        override val cause: Throwable? = null,
    ) : DataException()

    /**
     * Local exception
     *
     * Exceptions from the local layer
     */
    sealed class LocalException : DataException() {
        /**
         * Database exception
         *
         * Error when the database is accessed
         */
        data class DatabaseException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()
    }

    /**
     * Remote
     *
     * Exceptions from the remote layer
     */
    sealed class RemoteException : DataException() {
        /**
         * Network exception
         *
         * When host is not found or there is no connection
         */
        data class NetworkException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Unauthorized exception
         *
         * Http Error 401
         */
        data class UnauthorizedException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Forbidden exception
         *
         * Http Error 403
         */
        data class ForbiddenException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Not found exception
         *
         * Http Error 404
         */
        data class NotFoundException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Unprocessable Exception
         *
         * Http Error 422
         */
        data class UnprocessableException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Internal server exception
         *
         * Http Error 500
         */
        data class InternalServerException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Service unavailable exception
         *
         * Http Error 503
         */
        data class ServiceUnavailableException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()
    }
}
