package jp.co.yumemi.android.code_check.domain.entities

import jp.co.yumemi.android.code_check.domain.core.Pageable

data class SearchAll(
    val repositories: Pageable<Repository>?,
    val issues: Pageable<Issue>?,
    val pullRequests: Pageable<PullRequest>?,
    val people: Pageable<User>?,
    val organizations: Pageable<Organization>?,
)
