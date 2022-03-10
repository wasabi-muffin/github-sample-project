package io.github.gmvalentino8.github.sample.data.models

object DefaultModel {
    val repository = RepositoryModel(
        id = 0,
        name = "",
        description = null,
        owner = null,
        homepage = null,
        language = null,
        stargazersCount = 0,
        watchersCount = 0,
        forksCount = 0,
        openIssuesCount = 0,
        license = null
    )
    val issue = IssueModel(id = 0, number = 0, title = "", createdAt = "", repoName = "", state = "")
    val organization = OrganizationModel(id = 0, name = null, username = "", iconUrl = null, description = null)
    val pullRequest = PullRequestModel(id = 0, title = "", user = null, number = 0, repoName = "", date = "", status = "")
    val recentSearch = RecentSearchModel(searchText = "", timestamp = 0)
    val release = ReleaseModel(id = 0, name = null, tag = "", url = "", isDraft = false, description = null, author = null, createdAt = "", publishedAt = null)
    val user = UserModel(id = 0, username = "", iconUrl = null, name = null, blog = null, location = null, email = null, bio = null)
}
