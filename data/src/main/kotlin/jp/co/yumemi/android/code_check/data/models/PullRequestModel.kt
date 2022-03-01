package jp.co.yumemi.android.code_check.data.models

/**
 * Pull Request Data Model
 *
 * @property id unique id for this pull request
 * @property title title for this pull request
 * @property number issue number from the repository
 * @property user user who created this pull request
 * @property repoName name of the repository associated with this issue
 * @property createdAt date when this issue was created
 * @property status status of this pull request i.e. open, closed, draft, merged
 * @constructor Create empty Pull request
 */
data class PullRequestModel(
    val id: Int,
    val title: String,
    val user: UserModel?,
    val number: Int,
    val repoName: String,
    val date: String,
    val status: String,
)
