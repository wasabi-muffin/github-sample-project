package io.github.gmvalentino8.github.sample.domain.entities

object DefaultEntity {
    val repository = Repository(
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
    val issue = Issue(id = 0, number = 0, title = "", createdAt = "", repoName = "", status = "")
    val pullRequest = PullRequest(id = 0, title = "", number = 0, user = null, repoName = "", createdAt = "", status = "")
    val organization = Organization(id = 0, name = null, username = "", iconUrl = null, description = null)
    val user = User(id = 0, name = null, username = "", iconUrl = null, description = null)
    val release = Release(id = 0, name = null, tag = "", description = null, authorUsername = null, authorIconUrl = null, date = "")
    val recentSearch = RecentSearch(searchText = "", timestamp = 0)
}
