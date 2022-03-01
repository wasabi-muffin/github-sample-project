package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Pull Request Entity
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
@Parcelize
data class PullRequest(
    val id: Int,
    val title: String,
    val number: Int,
    val user: User?,
    val repoName: String,
    val createdAt: String,
    val status: String
) : Parcelable
