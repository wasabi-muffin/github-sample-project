package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Repository Entity
 *
 * @property id unique id for this repository
 * @property name name for this repository
 * @property description description for this repository
 * @property owner user who owns this repository
 * @property homepage homepage of this repository
 * @property language programming language of this repository i.e. Kotlin, Swift, ect.
 * @property stargazersCount number of stars
 * @property watchersCount number of watchers
 * @property forksCount number of works
 * @property openIssuesCount number of open issues
 * @property license name of the license used in this repository
 */
@Parcelize
data class Repository(
    val id: Int,
    val name: String,
    val description: String?,
    val owner: User?,
    val homepage: String?,
    val language: String?,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val openIssuesCount: Int,
    val license: String?,
) : Parcelable
