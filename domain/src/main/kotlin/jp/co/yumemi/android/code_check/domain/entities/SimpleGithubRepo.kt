package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SimpleGithubRepo(
    val name: String,
    val ownerName: String?,
    val ownerIconUrl: String?,
    val language: String?,
    val stargazersCount: Int,
) : Parcelable
