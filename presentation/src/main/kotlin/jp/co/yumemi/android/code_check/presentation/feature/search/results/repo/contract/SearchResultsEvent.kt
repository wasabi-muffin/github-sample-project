package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract

import android.os.Parcelable
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class SearchResultsEvent<T : Parcelable> : Event() {
    @Parcelize class NavigateBack<T : Parcelable> : SearchResultsEvent<T>()
    @Parcelize data class NavigateDetails<T : Parcelable>(val item: T) : SearchResultsEvent<T>()
}
