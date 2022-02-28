package jp.co.yumemi.android.code_check.data.utils

import kotlinx.datetime.Instant

fun interface InstantProvider {
    fun now(): Instant
}
