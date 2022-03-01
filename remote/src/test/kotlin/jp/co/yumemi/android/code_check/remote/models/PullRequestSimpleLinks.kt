package jp.co.yumemi.android.code_check.remote.models

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
