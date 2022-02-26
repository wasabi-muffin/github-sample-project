package jp.co.yumemi.android.code_check.data.models

data class ReleaseModel(
    val id: Int,
    val name: String,
    val tag: String,
    val url: String,
    val isDraft: Boolean,
    val description: String?,
    val author: UserModel?,
    val createdAt: String,
    val publishedAt: String,
)

