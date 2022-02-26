package jp.co.yumemi.android.code_check.presentation.core.utils

import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal fun <T, R : Result> DomainResult<T>.process(onSuccess: (T) -> R, onError: (DomainError) -> R) = when (this) {
    is DomainResult.Success -> flowOf(onSuccess(data))
    is DomainResult.Failure -> flowOf(onError(error))
}

internal fun <T, R : Result> DomainResult<T>.processFlow(onSuccess: (T) -> Flow<R>, onError: (DomainError) -> Flow<R>) = when (this) {
    is DomainResult.Success -> onSuccess(data)
    is DomainResult.Failure -> onError(error)
}
