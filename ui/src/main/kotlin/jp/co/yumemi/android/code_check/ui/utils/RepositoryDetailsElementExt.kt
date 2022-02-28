package jp.co.yumemi.android.code_check.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import jp.co.yumemi.android.code_check.domain.entities.RepositoryDetails
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Blue
import jp.co.yumemi.android.code_check.ui.primitives.Gray
import jp.co.yumemi.android.code_check.ui.primitives.Green
import jp.co.yumemi.android.code_check.ui.primitives.Orange
import jp.co.yumemi.android.code_check.ui.primitives.Red
import jp.co.yumemi.android.code_check.ui.primitives.Yellow

@DrawableRes
fun RepositoryDetails.Element.icon() = when (this) {
    RepositoryDetails.Element.Issues -> R.drawable.issue_opened
    RepositoryDetails.Element.PullRequests -> R.drawable.git_pull_request
    RepositoryDetails.Element.Releases -> R.drawable.tag
    RepositoryDetails.Element.Contributors -> R.drawable.people
    RepositoryDetails.Element.Watchers -> R.drawable.eye
    RepositoryDetails.Element.License -> R.drawable.law
}

@StringRes
fun RepositoryDetails.Element.label() = when (this) {
    RepositoryDetails.Element.Issues -> R.string.common_issues
    RepositoryDetails.Element.PullRequests -> R.string.common_pull_requests
    RepositoryDetails.Element.Releases -> R.string.common_releases
    RepositoryDetails.Element.Contributors -> R.string.common_contributors
    RepositoryDetails.Element.Watchers -> R.string.common_watchers
    RepositoryDetails.Element.License -> R.string.common_license
}

val RepositoryDetails.Element.iconBackground
    get() = when (this) {
        RepositoryDetails.Element.Issues -> Green.v500
        RepositoryDetails.Element.PullRequests -> Blue.v500
        RepositoryDetails.Element.Releases -> Gray.v800
        RepositoryDetails.Element.Contributors -> Orange.v500
        RepositoryDetails.Element.Watchers -> Yellow.v500
        RepositoryDetails.Element.License -> Red.v500
    }

@Composable
fun RepositoryDetails.Element.note(details: RepositoryDetails) = when (this) {
    RepositoryDetails.Element.Issues -> details.repository.openIssuesCount.toShortedString()
    RepositoryDetails.Element.PullRequests -> details.pullRequests?.size?.toShortedString()
    RepositoryDetails.Element.Releases -> details.releases?.size?.toDoubleDigitString()
    RepositoryDetails.Element.Contributors -> details.contributors?.size?.toDoubleDigitString()
    RepositoryDetails.Element.Watchers -> details.repository.watchersCount.toShortedString()
    RepositoryDetails.Element.License -> details.repository.license
}
