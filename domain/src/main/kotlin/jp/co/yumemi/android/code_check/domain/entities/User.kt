package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String?,
    val username: String,
    val iconUrl: String?,
    val description: String?,
) : Parcelable
