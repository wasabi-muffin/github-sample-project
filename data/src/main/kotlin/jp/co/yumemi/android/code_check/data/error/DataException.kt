package jp.co.yumemi.android.code_check.data.error

sealed class DataException : Throwable() {
    abstract override val message: String?
    abstract override val cause: Throwable?

    data class Unknown(
        override val message: String? = null,
        override val cause: Throwable? = null,
    ) : DataException()

    /**
     * Local
     */
    sealed class LocalException : DataException() {
        /**
         * Database
         */
        data class DatabaseException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()
    }

    /**
     * Remote
     */
    sealed class RemoteException : DataException() {
        /**
         * Timeout
         */
        data class NetworkException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Http Error 401
         */
        data class UnauthorizedException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Http Error 403
         */
        data class ForbiddenException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Http Error 404
         */
        data class NotFoundException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Http Error 422
         */
        data class UnprocessableException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Http Error 500
         */
        data class InternalServerException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()

        /**
         * Http Error 503
         */
        data class ServiceUnavailableException(
            override val message: String? = null,
            override val cause: Throwable? = null,
        ) : RemoteException()
    }
}
