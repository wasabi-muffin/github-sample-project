package io.github.gmvalentino8.github.sample.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import io.github.gmvalentino8.github.sample.domain.entities.SearchType
import io.github.gmvalentino8.github.sample.ui.R

@DrawableRes
fun SearchType.icon() = when (this) {
    SearchType.Repository -> R.drawable.repo
    SearchType.Issues -> R.drawable.issue_opened
    SearchType.PullRequests -> R.drawable.git_pull_request
    SearchType.People -> R.drawable.person
    SearchType.Organization -> R.drawable.organization
    SearchType.JumpTo -> R.drawable.arrow_right
}

@StringRes
fun SearchType.label() = when (this) {
    SearchType.Repository -> R.string.common_repositories
    SearchType.Issues -> R.string.common_issues
    SearchType.PullRequests -> R.string.common_pull_requests
    SearchType.People -> R.string.common_people
    SearchType.Organization -> R.string.common_organizations
    SearchType.JumpTo -> null
}
