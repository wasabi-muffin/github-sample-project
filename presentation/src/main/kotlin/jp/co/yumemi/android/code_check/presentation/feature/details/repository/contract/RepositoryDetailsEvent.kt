package jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class RepositoryDetailsEvent : Event() {
    @Parcelize object NavigateBack : RepositoryDetailsEvent()
}
