package jp.co.yumemi.android.code_check.data.models

data class PullRequestModel(
    val id: Int,
    val title: String,
    val user: UserModel?,
    val number: Int,
    val repository: RepositoryModel?,
    val date: String,
    val status: String,
)
