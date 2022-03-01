package jp.co.yumemi.android.code_check.data.models

data class SearchResultModel<T>(
    val items: List<T>,
    val totalCount: Int
)
