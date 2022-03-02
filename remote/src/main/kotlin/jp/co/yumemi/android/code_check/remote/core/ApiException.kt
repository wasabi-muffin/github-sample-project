package jp.co.yumemi.android.code_check.remote.core

/**
 * Api exception
 *
 * Wrapper for api [Throwable]s
 */
sealed class ApiException: Throwable() {
    abstract val statusCode: Int
    abstract override val message: String?
    abstract override val cause: Throwable?

    /**
     * Github api exception
     *
     * Exceptions from the Github API
     *
     * @property statusCode HTTP state code
     */
    data class GithubApiException(
        override val statusCode: Int,
        override val message: String?,
        override val cause: Throwable? = null
    ) : ApiException()
}
