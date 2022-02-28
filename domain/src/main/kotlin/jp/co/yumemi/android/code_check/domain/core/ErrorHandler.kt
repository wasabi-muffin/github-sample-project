package jp.co.yumemi.android.code_check.domain.core

/**
 * Maps throwables to DomainError
 */
fun interface ErrorHandler {
    fun handle(throwable: Throwable): DomainError
}
