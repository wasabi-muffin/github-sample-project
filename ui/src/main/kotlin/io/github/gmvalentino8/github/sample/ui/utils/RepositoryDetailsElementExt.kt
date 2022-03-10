package io.github.gmvalentino8.github.sample.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import io.github.gmvalentino8.github.sample.domain.entities.RepositoryDetails
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.primitives.Blue
import io.github.gmvalentino8.github.sample.ui.primitives.Gray
import io.github.gmvalentino8.github.sample.ui.primitives.Green
import io.github.gmvalentino8.github.sample.ui.primitives.Orange
import io.github.gmvalentino8.github.sample.ui.primitives.Red
import io.github.gmvalentino8.github.sample.ui.primitives.Yellow

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
