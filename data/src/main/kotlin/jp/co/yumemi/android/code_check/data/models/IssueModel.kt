package jp.co.yumemi.android.code_check.data.models

import jp.co.yumemi.android.code_check.domain.entities.Repository

data class IssueModel(
    val id: Int,
    val number: Int,
    val title: String,
    val createdAt: String,
    val repository: RepositoryModel?,
    val state: String,
)
