package jp.co.yumemi.android.code_check.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.ui.R

@DrawableRes
fun SearchType.icon() = when (this) {
    SearchType.Repo -> R.drawable.repo
}

@StringRes
fun SearchType.label() = when (this) {
    SearchType.Repo -> R.string.common_repositories
}
