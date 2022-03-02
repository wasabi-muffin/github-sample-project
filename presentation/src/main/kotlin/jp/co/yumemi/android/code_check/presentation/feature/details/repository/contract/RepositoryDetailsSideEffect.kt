package jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect

sealed class RepositoryDetailsSideEffect : SideEffect {
    data class LoadDetails(val repository: Repository) : RepositoryDetailsSideEffect()
}
