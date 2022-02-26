package jp.co.yumemi.android.code_check.domain.core

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pageable<T : Parcelable>(
    val items: List<T>,
    val totalCount: Int
) : Parcelable
