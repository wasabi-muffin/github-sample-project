package jp.co.yumemi.android.code_check.presentation.feature.search.results.contract

import android.os.Parcelable
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.entities.Pageable
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventResult
import jp.co.yumemi.android.code_check.presentation.core.contract.Result
import jp.co.yumemi.android.code_check.presentation.core.contract.SendEventResult

sealed class SearchResultsResult<T : Parcelable> : Result {
    class Loading<T : Parcelable> : SearchResultsResult<T>()
    data class SearchSuccess<T : Parcelable>(val data: Pageable<T>) : SearchResultsResult<T>()
    data class SearchError<T : Parcelable>(val error: DomainError) : SearchResultsResult<T>()
    class RefreshLoading<T : Parcelable> : SearchResultsResult<T>()
    class PageLoading<T : Parcelable> : SearchResultsResult<T>()
    class ResolveError<T : Parcelable> : SearchResultsResult<T>()
    data class ProcessEvent<T : Parcelable>(override val event: SearchResultsEvent<T>) : SearchResultsResult<T>(), ProcessEventResult<SearchResultsEvent<T>>
    data class SendEvent<T : Parcelable>(override val event: SearchResultsEvent<T>) : SearchResultsResult<T>(), SendEventResult<SearchResultsEvent<T>>
}
