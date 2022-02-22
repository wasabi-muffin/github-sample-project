package jp.co.yumemi.android.code_check.domain.core

sealed class DomainResult<out R> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    data class Failure(val error: DomainError) : DomainResult<Nothing>()
}
