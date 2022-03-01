package jp.co.yumemi.android.code_check.data.utils

import kotlinx.datetime.Instant

/**
 * Instant provider
 *
 * Wrapper to provide the current system time
 */
fun interface InstantProvider {
    fun now(): Instant
}
