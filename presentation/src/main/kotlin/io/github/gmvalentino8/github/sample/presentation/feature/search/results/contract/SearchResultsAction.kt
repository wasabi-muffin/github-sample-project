package io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract

import android.os.Parcelable
import io.github.gmvalentino8.github.sample.presentation.core.contract.Action
import io.github.gmvalentino8.github.sample.presentation.core.contract.ProcessEventAction

sealed class SearchResultsAction<T : Parcelable> : Action {
    class NavigateBack<T : Parcelable> : SearchResultsAction<T>()
    class LoadSearch<T : Parcelable> : SearchResultsAction<T>()
    data class NavigateDetails<T : Parcelable>(val item: T) : SearchResultsAction<T>()
    class RefreshSearch<T : Parcelable> : SearchResultsAction<T>()
    class PageSearch<T : Parcelable> : SearchResultsAction<T>()
    class ResolveError<T : Parcelable> : SearchResultsAction<T>()
    data class ProcessEvent<T : Parcelable>(override val event: SearchResultsEvent<T>) : SearchResultsAction<T>(), ProcessEventAction<SearchResultsEvent<T>>
}
