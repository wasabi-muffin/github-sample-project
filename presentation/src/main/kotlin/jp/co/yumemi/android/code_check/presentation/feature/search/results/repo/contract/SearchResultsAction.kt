package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import android.os.Parcelable
import jp.co.yumemi.android.code_check.presentation.core.contract.Action
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventAction

sealed class SearchResultsAction<T : Parcelable> : Action {
    class NavigateBack<T : Parcelable> : SearchResultsAction<T>()
    class LoadSearch<T : Parcelable> : SearchResultsAction<T>()
    data class NavigateDetails<T : Parcelable>(val item: T) : SearchResultsAction<T>()
    class RefreshSearch<T : Parcelable> : SearchResultsAction<T>()
    class PageSearch<T : Parcelable> : SearchResultsAction<T>()
    class ResolveError<T : Parcelable> : SearchResultsAction<T>()
    data class ProcessEvent<T : Parcelable>(override val event: SearchResultsEvent<T>) : SearchResultsAction<T>(), ProcessEventAction<SearchResultsEvent<T>>
}
