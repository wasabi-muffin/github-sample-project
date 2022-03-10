package io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract

import android.os.Parcelable
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class SearchResultsEvent<T : Parcelable> : Event() {
    @Parcelize class NavigateBack<T : Parcelable> : SearchResultsEvent<T>()
    @Parcelize data class NavigateDetails<T : Parcelable>(val item: T) : SearchResultsEvent<T>()
}
