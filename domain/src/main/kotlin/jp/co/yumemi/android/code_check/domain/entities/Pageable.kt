package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Pageable Entity
 *
 * Wrapper for pageable lists
 *
 * @property items list of results
 * @property totalCount total count of all results (including those of which have not yet been paged)
 */
@Parcelize
data class Pageable<T : Parcelable>(
    val items: List<T>,
    val totalCount: Int
) : Parcelable
