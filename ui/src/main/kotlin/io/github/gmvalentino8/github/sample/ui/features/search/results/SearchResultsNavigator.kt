package io.github.gmvalentino8.github.sample.ui.features.search.results

import android.os.Parcelable

interface SearchResultsNavigator<T : Parcelable> {
    fun back()
    fun details(item: T)
}
