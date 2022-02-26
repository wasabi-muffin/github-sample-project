package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubRepo(
    val name: String,
    val ownerName: String?,
    val ownerIconUrl: String?,
    val description: String?,
    val url: String?,
    val stargazersCount: Int,
    val openIssuesCount: Int,
    val releasesCount: Int,
    val contributorsCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val license: String?,
) : Parcelable
