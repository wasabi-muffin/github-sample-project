package jp.co.yumemi.android.code_check.data.models

import android.os.Parcelable
import jp.co.yumemi.android.code_check.domain.entities.User

data class PullRequestModel(
    val id: Int,
    val title: String,
    val user: UserModel?,
    val date: String,
    val isDraft: Boolean,
)
