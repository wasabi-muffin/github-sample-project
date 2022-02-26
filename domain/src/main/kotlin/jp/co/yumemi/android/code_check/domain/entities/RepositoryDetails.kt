package jp.co.yumemi.android.code_check.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RepositoryDetails(
    val repository: Repository,
    val releases: List<Release>,
    val contributors: List<User>,
) : Parcelable