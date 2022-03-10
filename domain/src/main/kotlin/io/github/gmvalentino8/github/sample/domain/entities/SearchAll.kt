package io.github.gmvalentino8.github.sample.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Search All Entity
 *
 * Holds information for searching for multiple types
 *
 * @property repositories search repository results
 * @property issues search issue results
 * @property pullRequests search pull request results
 * @property people search people results
 * @property organizations search organization results
 */
@Parcelize
data class SearchAll(
    val repositories: Pageable<Repository>,
    val issues: Pageable<Issue>,
    val pullRequests: Pageable<PullRequest>,
    val people: Pageable<User>,
    val organizations: Pageable<Organization>,
) : Parcelable
