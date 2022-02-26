package jp.co.yumemi.android.code_check.presentation.feature.details.repo

import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine

class RepoDetailsStateMachine : StateMachine<RepoDetailsIntent,
    RepoDetailsAction,
    RepoDetailsResult,
    RepoDetailsViewState,
    RepoDetailsEvent,
    RepoDetailsSideEffect>(
    builder = {
        state<RepoDetailsViewState> {
            interpret<RepoDetailsIntent.ProcessEvent> { RepoDetailsAction.ProcessEvent(it.event) }
            interpret<RepoDetailsIntent.ClickBack> { RepoDetailsAction.NavigateBack }
            process<RepoDetailsAction.ProcessEvent> {
                result { RepoDetailsResult.ProcessEvent(it.event) }
            }
            process<RepoDetailsAction.NavigateBack> {
                result { RepoDetailsResult.SendEvent(RepoDetailsEvent.NavigateBack) }
            }
        }

        state<RepoDetailsViewState.Initial> {
            interpret<RepoDetailsIntent.OnStart> { RepoDetailsAction.LoadDetails }
            process<RepoDetailsAction.LoadDetails> {
                result { RepoDetailsResult.Loading }
                sideEffect { RepoDetailsSideEffect.LoadDetails(repo = repo) }
            }
            reduce<RepoDetailsResult.Loading> { RepoDetailsViewState.Loading(repo = repo) }
        }

        state<RepoDetailsViewState.Loading> {
            reduce<RepoDetailsResult.LoadDetailsSuccess> {
                RepoDetailsViewState.Stable.Initial(repo = repo, details = it.details)
            }
            reduce<RepoDetailsResult.LoadDetailsError> {
                RepoDetailsViewState.Error(repo = repo, error = it.error)
            }
        }

        state<RepoDetailsViewState.Stable> {
            interpret<RepoDetailsIntent.PullToRefresh> { RepoDetailsAction.RefreshDetails }
            process<RepoDetailsAction.RefreshDetails> {
                result { RepoDetailsResult.RefreshLoading }
                sideEffect { RepoDetailsSideEffect.LoadDetails(repo = repo) }
            }
            reduce<RepoDetailsResult.RefreshLoading> {
                RepoDetailsViewState.Stable.RefreshLoading(repo = repo, details = details)
            }
        }

        state<RepoDetailsViewState.Stable.RefreshLoading> {
            reduce<RepoDetailsResult.LoadDetailsSuccess> {
                RepoDetailsViewState.Stable.Initial(repo = repo, details = it.details)
            }
            reduce<RepoDetailsResult.LoadDetailsError> {
                RepoDetailsViewState.Stable.RefreshError(repo = repo, details = details, error = it.error)
            }
        }

        state<RepoDetailsViewState.Stable.RefreshError> {
            interpret<RepoDetailsIntent.ClickErrorOK> { RepoDetailsAction.ResolveError }
            process<RepoDetailsAction.ResolveError> {
                result { RepoDetailsResult.ResolveError }
            }
            reduce<RepoDetailsResult.ResolveError> {
                RepoDetailsViewState.Stable.Initial(repo = repo, details = details)
            }
        }

        state<RepoDetailsViewState.Error> {
            interpret<RepoDetailsIntent.ClickTryAgain> { RepoDetailsAction.LoadDetails }
            process<RepoDetailsAction.LoadDetails> {
                result { RepoDetailsResult.Loading }
                sideEffect { RepoDetailsSideEffect.LoadDetails(repo = repo) }
            }
            reduce<RepoDetailsResult.Loading> { RepoDetailsViewState.Loading(repo = repo) }
        }
    }
)
