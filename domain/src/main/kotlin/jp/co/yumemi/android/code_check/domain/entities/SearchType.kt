package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Search Type Entity
 *
 * All the possible search options
 */
@Parcelize
enum class SearchType : Parcelable {
    Repository,
    Issues,
    PullRequests,
    People,
    Organization,
    JumpTo
}
