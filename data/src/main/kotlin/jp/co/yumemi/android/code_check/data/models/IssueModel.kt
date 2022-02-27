package jp.co.yumemi.android.code_check.data.models

data class IssueModel(
    val id: Int,
    val number: Int,
    val title: String,
    val createdAt: String,
    val repoName: String,
    val state: String,
)
