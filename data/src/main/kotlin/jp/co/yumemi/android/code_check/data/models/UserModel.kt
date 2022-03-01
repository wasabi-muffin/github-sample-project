package jp.co.yumemi.android.code_check.data.models

/**
 * User Data Model
 *
 * @property id unique id for this user
 * @property name name of this user
 * @property username login username associated with this user
 * @property iconUrl url for the avatar of this user
 * @property blog url for the blog of this user
 * @property location location of this user
 * @property email email of this user
 * @property bio bio for this organization
 */
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
