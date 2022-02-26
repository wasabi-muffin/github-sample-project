package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repository(
    val id: Int,
    val name: String,
    val description: String?,
    val ownerName: String?,
    val ownerIconUrl: String?,
    val homepage: String?,
    val language: String?,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val openIssuesCount: Int,
    val license: String?,
) : Parcelable
