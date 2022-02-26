package jp.co.yumemi.android.code_check.data.models

data class UserModel(
    val id: Int,
    val username: String,
    val iconUrl: String?,
    val name: String?,
    val blog: String?,
    val location: String?,
    val email: String?,
    val bio: String?,
)
