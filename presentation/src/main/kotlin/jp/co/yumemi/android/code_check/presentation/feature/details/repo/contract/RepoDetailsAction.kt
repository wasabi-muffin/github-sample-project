package jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Action

sealed class RepoDetailsAction : Action {
    object LoadDetails : RepoDetailsAction()
    object NavigateBack : RepoDetailsAction()
    object RefreshDetails : RepoDetailsAction()
    object ResolveError : RepoDetailsAction()
}
