package jp.co.yumemi.android.code_check.ui.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.ui.R

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
