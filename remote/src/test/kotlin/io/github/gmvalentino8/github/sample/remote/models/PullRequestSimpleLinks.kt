package io.github.gmvalentino8.github.sample.remote.models

val DefaultModel.pullRequestSimpleLinks
    get() = PullRequestSimpleLinksApiModel(
        comments = link,
        commits = link,
        statuses = link,
        html = link,
        issue = link,
        reviewComments = link,
        self = link,
        reviewComment = link
    )
