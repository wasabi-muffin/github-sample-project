package io.github.gmvalentino8.github.sample.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Repository Details Entity
 *
 * Holds information related to a single repository
 *
 * @property repository repository that is accessed
 * @property releases releases for this repository
 * @property contributors contributors for this repository
 * @property pullRequests pull requests for this repository
 */
@Parcelize
data class RepositoryDetails(
    val repository: Repository,
    val releases: List<Release>?,
    val contributors: List<User>?,
    val pullRequests: List<PullRequest>?
) : Parcelable {

    enum class Element {
        Issues, PullRequests, Releases, Contributors, Watchers, License
    }
}
