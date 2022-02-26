package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class RepoDetailsEvent : Event() {
    @Parcelize object NavigateBack : RepoDetailsEvent()
}
