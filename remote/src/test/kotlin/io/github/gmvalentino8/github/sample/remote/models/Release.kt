package io.github.gmvalentino8.github.sample.remote.models

val DefaultModel.release get() = ReleaseApiModel(
    url = "",
    htmlUrl = "",
    assetsUrl = "",
    uploadUrl = "",
    tarballUrl = null,
    zipballUrl = null,
    id = 0,
    nodeId = "",
    tagName = "",
    targetCommitish = "",
    name = null,
    draft = false,
    prerelease = false,
    createdAt = "",
    publishedAt = null,
    author = simpleUser,
    assets = listOf(),
    body = null,
    bodyHtml = null,
    bodyText = null,
    mentionsCount = null,
    discussionUrl = null,
    reactions = null
)

