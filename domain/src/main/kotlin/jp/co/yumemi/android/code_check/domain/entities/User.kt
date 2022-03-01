package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * User Entity
 *
 * @property id unique id for this user
 * @property name name of this user
 * @property username login username associated with this user
 * @property iconUrl url for the avatar of this user
 * @property description bio for this user
 */
@Parcelize
data class User(
    val id: Int,
    val name: String?,
    val username: String,
    val iconUrl: String?,
    val description: String?,
) : Parcelable
