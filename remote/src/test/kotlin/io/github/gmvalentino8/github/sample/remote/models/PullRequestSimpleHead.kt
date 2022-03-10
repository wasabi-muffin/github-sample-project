package io.github.gmvalentino8.github.sample.remote.models

val DefaultModel.pullRequestSimpleHead
    get() = PullRequestSimpleHeadApiModel(
        label = "",
        ref = "",
        repo = repository,
        sha = "",
        user = null
    )
