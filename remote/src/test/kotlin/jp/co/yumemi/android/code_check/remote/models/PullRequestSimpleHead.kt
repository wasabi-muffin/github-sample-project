package jp.co.yumemi.android.code_check.remote.models

val DefaultModel.pullRequestSimpleHead
    get() = PullRequestSimpleHeadApiModel(
        label = "",
        ref = "",
        repo = repository,
        sha = "",
        user = null
    )
