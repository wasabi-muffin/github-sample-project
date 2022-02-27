package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Issue(
    val id: Int,
    val number: Int,
    val title: String,
    val createdAt: String,
    val repoName: String,
    val status: String,
) : Parcelable
