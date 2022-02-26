package jp.co.yumemi.android.code_check.ui.components.error

import androidx.annotation.StringRes
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.ui.R

@StringRes
fun DomainError.title(): Int = when (this) {
    is DomainError.Maintenance -> TODO()
    is DomainError.NeedUpdate -> TODO()
    is DomainError.Network -> TODO()
    is DomainError.Server -> TODO()
    is DomainError.Unknown -> R.string.placeholder_error_title_unknown
}

@StringRes
fun DomainError.description(): Int = when (this) {
    is DomainError.Maintenance -> TODO()
    is DomainError.NeedUpdate -> TODO()
    is DomainError.Network -> TODO()
    is DomainError.Server -> TODO()
    is DomainError.Unknown -> R.string.placeholder_error_description_unknown
}
