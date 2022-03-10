package io.github.gmvalentino8.github.sample.presentation.feature.search.results.contract

import android.os.Parcelable
import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState
import kotlinx.parcelize.Parcelize

sealed class SearchResultsViewState<T : Parcelable> : ViewState {
    internal abstract val searchText: String

    @Parcelize data class Initial<T : Parcelable>(
        override val searchText: String
    ) : SearchResultsViewState<T>()

    @Parcelize data class Loading<T : Parcelable>(
        override val searchText: String
    ) : SearchResultsViewState<T>()

    @Parcelize data class Empty<T : Parcelable>(
        override val searchText: String
    ) : SearchResultsViewState<T>()

    sealed class Stable<T : Parcelable> : SearchResultsViewState<T>() {
        abstract val results: List<T>
        internal abstract val pageNumber: Int
        internal abstract val totalCount: Int
        val pageable: Boolean get() = results.size < totalCount

        @Parcelize data class Initial<T : Parcelable>(
            override val searchText: String,
            override val results: List<T>,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable<T>()

        @Parcelize data class PageLoading<T : Parcelable>(
            override val searchText: String,
            override val results: List<T>,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable<T>()

        @Parcelize data class PageError<T : Parcelable>(
            override val searchText: String,
            override val results: List<T>,
            override val pageNumber: Int,
            override val totalCount: Int,
            val error: DomainError,
        ) : Stable<T>()

        @Parcelize data class RefreshLoading<T : Parcelable>(
            override val searchText: String,
            override val results: List<T>,
            override val pageNumber: Int,
            override val totalCount: Int,
        ) : Stable<T>()

        @Parcelize data class RefreshError<T : Parcelable>(
            override val searchText: String,
            override val results: List<T>,
            override val pageNumber: Int,
            override val totalCount: Int,
            val error: DomainError,
        ) : Stable<T>()
    }

    @Parcelize data class Error<T : Parcelable>(
        val error: DomainError,
        override val searchText: String
    ) : SearchResultsViewState<T>()
}
