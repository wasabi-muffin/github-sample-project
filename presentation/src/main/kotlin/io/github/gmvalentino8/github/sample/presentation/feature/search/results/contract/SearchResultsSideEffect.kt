package io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract

import android.os.Parcelable
import io.github.gmvalentino8.github.sample.presentation.statemachine.contract.SideEffect

sealed class SearchResultsSideEffect<T : Parcelable> : SideEffect {
    data class Search<T : Parcelable>(val searchText: String, val pageNumber: Int) : SearchResultsSideEffect<T>()
}
