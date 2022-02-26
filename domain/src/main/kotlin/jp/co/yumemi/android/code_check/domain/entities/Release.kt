package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Release(
    val id: Int,
    val name: String,
    val tag: String,
    val description: String?,
    val authorUsername: String?,
    val authorIconUrl: String?,
    val date: String,
) : Parcelable
