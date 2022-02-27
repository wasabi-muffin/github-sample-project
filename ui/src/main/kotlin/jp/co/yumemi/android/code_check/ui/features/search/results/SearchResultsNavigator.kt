package jp.co.yumemi.android.code_check.ui.features.search.results

import android.os.Parcelable

interface SearchResultsNavigator<T : Parcelable> {
    fun back()
    fun details(item: T)
}
