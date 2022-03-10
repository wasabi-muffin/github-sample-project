package io.github.gmvalentino8.github.sample.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Release Entity
 *
 * @property id unique id for this release
 * @property name name for this release
 * @property tag tag used for this release
 * @property description description for this release
 * @property authorUsername username of the author who created this release
 * @property authorIconUrl url for the avatar of the author who published this release
 * @property date date this release was published
 */
@Parcelize
data class Release(
    val id: Int,
    val name: String?,
    val tag: String,
    val description: String?,
    val authorUsername: String?,
    val authorIconUrl: String?,
    val date: String,
) : Parcelable
