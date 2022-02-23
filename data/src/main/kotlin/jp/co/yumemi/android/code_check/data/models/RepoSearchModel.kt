package jp.co.yumemi.android.code_check.data.models

data class RepoSearchModel(
    val name: String,
    val ownerIconUrl: String?,
    val language: String?,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val openIssuesCount: Int,
)
