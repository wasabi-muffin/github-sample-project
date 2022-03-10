package io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract

import android.os.Parcelable
import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.domain.entities.Pageable
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventResult
import io.github.gmvalentino8.github.sample.presentation.core.contract.Result
import io.github.gmvalentino8.github.sample.presentation.core.contract.SendEventResult

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
