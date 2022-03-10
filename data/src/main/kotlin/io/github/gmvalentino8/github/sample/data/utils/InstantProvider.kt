package io.github.gmvalentino8.github.sample.data.utils

import kotlinx.datetime.Instant

/**
 * Instant provider
 *
 * Wrapper to provide the current system time
 */
fun interface InstantProvider {
    fun now(): Instant
}
