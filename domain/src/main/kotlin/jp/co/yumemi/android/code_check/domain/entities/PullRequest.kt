package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PullRequest(
    val id: Int,
    val title: String,
    val user: User?,
    val date: String,
    val isDraft: Boolean,
) : Parcelable
