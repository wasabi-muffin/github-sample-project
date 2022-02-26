package jp.co.yumemi.android.code_check.data.models

data class SearchResultModel<T>(
    val repos: List<T>,
    val totalCount: Int
)
