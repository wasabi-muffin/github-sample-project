package jp.co.yumemi.android.code_check.data.models

/**
 * Issue Data Model
 *
 * @property id unique id for this issue
 * @property number issue number from the repository
 * @property title title for this issue
 * @property createdAt date when this issue was created
 * @property repoName name of the repository associated with this issue
 * @property state status of this issue i.e. open, closed, reopened
 */
data class IssueModel(
    val id: Int,
    val number: Int,
    val title: String,
    val createdAt: String,
    val repoName: String,
    val state: String,
)
