package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PullRequest(
    val id: Int,
    val title: String,
    val number: Int,
    val user: User?,
    val repoName: String,
    val createdAt: String,
    val status: String
) : Parcelable
