package jp.co.yumemi.android.code_check.ui.utils

import androidx.annotation.DrawableRes
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.ui.R

@DrawableRes
fun RepositoryDetails.Element.icon() = when (this) {
    RepositoryDetails.Element.Issues -> R.drawable.issue_opened
    RepositoryDetails.Element.PullRequests -> R.drawable.git_pull_request
    RepositoryDetails.Element.Releases -> R.drawable.tag
    RepositoryDetails.Element.Contributors -> R.drawable.people
    RepositoryDetails.Element.Watchers -> R.drawable.eye
    RepositoryDetails.Element.License -> R.drawable.law
}

@DrawableRes
fun RepositoryDetails.Element.label() = when (this) {
    RepositoryDetails.Element.Issues -> R.string.common_issues
    RepositoryDetails.Element.PullRequests -> R.string.common_pull_requests
    RepositoryDetails.Element.Releases -> R.string.common_releases
    RepositoryDetails.Element.Contributors -> R.string.common_contributors
    RepositoryDetails.Element.Watchers -> R.string.common_watchers
    RepositoryDetails.Element.License -> R.string.common_license
}
