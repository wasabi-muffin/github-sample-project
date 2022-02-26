package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.statemachine.contract.SideEffect

sealed class RepoDetailsSideEffect : SideEffect {
    data class LoadDetails(val repo: Repository) : RepoDetailsSideEffect()
}
