package jp.co.yumemi.android.code_check.data.models

data class RepoSearchResultModel(
    val repos: List<RepoSearchModel>,
    val totalCount: Int
)
