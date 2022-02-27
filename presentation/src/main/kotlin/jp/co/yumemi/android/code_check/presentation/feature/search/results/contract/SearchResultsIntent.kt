package jp.co.yumemi.android.code_check.presentation.feature.search.results.contract

import android.os.Parcelable
import jp.co.yumemi.android.code_check.presentation.core.contract.Intent
import jp.co.yumemi.android.code_check.presentation.core.contract.ProcessEventIntent

sealed class SearchResultsIntent<T : Parcelable> : Intent {
    class OnStart<T: Parcelable> : SearchResultsIntent<T>()
    class ClickBack<T: Parcelable> : SearchResultsIntent<T>()
    class ClickTryAgain<T: Parcelable> : SearchResultsIntent<T>()
    data class ClickItem<T: Parcelable>(val item: T) : SearchResultsIntent<T>()
    class PullToRefresh<T: Parcelable> : SearchResultsIntent<T>()
    class ScrollToBottom<T: Parcelable> : SearchResultsIntent<T>()
    class ClickErrorRetry<T: Parcelable> : SearchResultsIntent<T>()
    class ClickErrorOk<T: Parcelable> : SearchResultsIntent<T>()
    data class ProcessEvent<T: Parcelable>(override val event: SearchResultsEvent<T>) : SearchResultsIntent<T>(), ProcessEventIntent<SearchResultsEvent<T>>
}
