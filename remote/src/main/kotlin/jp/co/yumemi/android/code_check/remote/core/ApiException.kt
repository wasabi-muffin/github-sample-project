package jp.co.yumemi.android.code_check.remote.core

sealed class ApiException: Throwable() {
    abstract val statusCode: Int
    abstract override val message: String?
    abstract override val cause: Throwable?

    data class GithubApiException(
        override val statusCode: Int,
        override val message: String?,
        override val cause: Throwable? = null
    ) : ApiException()
}
