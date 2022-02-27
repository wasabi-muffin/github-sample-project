package jp.co.yumemi.android.code_check.presentation.feature.search.results.contract

import android.os.Parcelable
import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect

sealed class SearchResultsSideEffect<T : Parcelable> : SideEffect {
    data class Search<T : Parcelable>(val searchText: String, val pageNumber: Int) : SearchResultsSideEffect<T>()
}
