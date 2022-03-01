package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Issue Entity
 *
 * @property id unique id for this issue
 * @property number issue number from the repository
 * @property title title for this issue
 * @property createdAt date when this issue was created
 * @property repoName name of the repository associated with this issue
 * @property status status of this issue i.e. open, closed, reopened
 */
@Parcelize
data class Issue(
    val id: Int,
    val number: Int,
    val title: String,
    val createdAt: String,
    val repoName: String,
    val status: String,
) : Parcelable
