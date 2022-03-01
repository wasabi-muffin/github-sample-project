package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Organization Entity
 *
 * @property id unique id for this organization
 * @property name name of this organization
 * @property username login username associated with this organization
 * @property iconUrl url for the avatar of this organization
 * @property description bio for this organization
 */
@Parcelize
data class Organization(
    val id: Int,
    val name: String?,
    val username: String,
    val iconUrl: String?,
    val description: String?,
) : Parcelable
