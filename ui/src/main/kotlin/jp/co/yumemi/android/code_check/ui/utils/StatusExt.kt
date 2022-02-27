package jp.co.yumemi.android.code_check.ui.utils

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.Gray
import jp.co.yumemi.android.code_check.ui.primitives.Green
import jp.co.yumemi.android.code_check.ui.primitives.Purple
import jp.co.yumemi.android.code_check.ui.primitives.Red

data class IssueStatus(val value: String) {
    @DrawableRes val icon: Int = when (value) {
        "open" -> R.drawable.issue_opened
        "closed" -> R.drawable.issue_closed
        "reopened" -> R.drawable.issue_reopened
        else -> R.drawable.issue_opened
    }
    val iconTint: Color = when (value) {
        "open" -> Green.v500
        "closed" -> Purple.v500
        "reopened" -> Green.v500
        else -> Github.Black
    }
}

data class PullRequestStatus(val value: String) {
    @DrawableRes val icon: Int = when (value) {
        "open" -> R.drawable.git_pull_request
        "draft" -> R.drawable.git_pull_request_draft
        "closed" -> R.drawable.git_pull_request_draft
        "merged" -> R.drawable.git_merge
        else -> R.drawable.git_pull_request
    }
    val iconTint: Color = when (value) {
        "open" -> Green.v500
        "draft" -> Gray.v500
        "closed" -> Red.v500
        "merged" -> Purple.v500
        else -> Github.Black
    }
}
