package io.github.gmvalentino8.github.sample.ui.components.error

import androidx.annotation.StringRes
import io.github.gmvalentino8.github.sample.domain.core.DomainError
import io.github.gmvalentino8.github.sample.ui.R

@StringRes
fun DomainError.title(): Int = when (this) {
    is DomainError.Maintenance -> R.string.error_maintenance_title
    is DomainError.Network -> R.string.error_network_title
    is DomainError.Server -> R.string.error_server_title
    is DomainError.Unknown -> R.string.error_unknown_title
}

@StringRes
fun DomainError.description(): Int? = when (this) {
    is DomainError.Maintenance -> R.string.error_try_again_later
    is DomainError.Network -> null
    is DomainError.Server -> R.string.error_try_again_later
    is DomainError.Unknown -> R.string.error_try_again_later
}
