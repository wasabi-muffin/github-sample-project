package jp.co.yumemi.android.code_check.domain.core

fun interface ErrorHandler {
    fun handleError(throwable: Throwable): DomainError
}
