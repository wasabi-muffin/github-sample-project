package jp.co.yumemi.android.code_check.presentation.feature.details.repository

import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine

class RepositoryDetailsStateMachine : StateMachine<RepositoryDetailsIntent,
    RepositoryDetailsAction,
    RepositoryDetailsResult,
    RepositoryDetailsViewState,
    RepositoryDetailsEvent,
    RepositoryDetailsSideEffect>(
    builder = {
        state<RepositoryDetailsViewState> {
            interpret<RepositoryDetailsIntent.ProcessEvent> { RepositoryDetailsAction.ProcessEvent(it.event) }
            interpret<RepositoryDetailsIntent.ClickBack> { RepositoryDetailsAction.NavigateBack }
            process<RepositoryDetailsAction.ProcessEvent> {
                result { RepositoryDetailsResult.ProcessEvent(it.event) }
            }
            process<RepositoryDetailsAction.NavigateBack> {
                result { RepositoryDetailsResult.SendEvent(RepositoryDetailsEvent.NavigateBack) }
            }
        }

        state<RepositoryDetailsViewState.Initial> {
            interpret<RepositoryDetailsIntent.OnStart> { RepositoryDetailsAction.LoadDetails }
            process<RepositoryDetailsAction.LoadDetails> {
                result { RepositoryDetailsResult.Loading }
                sideEffect { RepositoryDetailsSideEffect.LoadDetails(repository = repository) }
            }
            reduce<RepositoryDetailsResult.Loading> { RepositoryDetailsViewState.Loading(repository = repository) }
        }

        state<RepositoryDetailsViewState.Loading> {
            reduce<RepositoryDetailsResult.LoadDetailsSuccess> {
                RepositoryDetailsViewState.Stable.Initial(repository = repository, details = it.details)
            }
            reduce<RepositoryDetailsResult.LoadDetailsError> {
                RepositoryDetailsViewState.Error(repository = repository, error = it.error)
            }
        }

        state<RepositoryDetailsViewState.Stable> {
            interpret<RepositoryDetailsIntent.PullToRefresh> { RepositoryDetailsAction.RefreshDetails }
            process<RepositoryDetailsAction.RefreshDetails> {
                result { RepositoryDetailsResult.RefreshLoading }
                sideEffect { RepositoryDetailsSideEffect.LoadDetails(repository = repository) }
            }
            reduce<RepositoryDetailsResult.RefreshLoading> {
                RepositoryDetailsViewState.Stable.RefreshLoading(repository = repository, details = details)
            }
        }

        state<RepositoryDetailsViewState.Stable.RefreshLoading> {
            reduce<RepositoryDetailsResult.LoadDetailsSuccess> {
                RepositoryDetailsViewState.Stable.Initial(repository = repository, details = it.details)
            }
            reduce<RepositoryDetailsResult.LoadDetailsError> {
                RepositoryDetailsViewState.Stable.RefreshError(repository = repository, details = details, error = it.error)
            }
        }

        state<RepositoryDetailsViewState.Stable.RefreshError> {
            interpret<RepositoryDetailsIntent.ClickErrorOk> { RepositoryDetailsAction.ResolveError }
            process<RepositoryDetailsAction.ResolveError> {
                result { RepositoryDetailsResult.ResolveError }
            }
            reduce<RepositoryDetailsResult.ResolveError> {
                RepositoryDetailsViewState.Stable.Initial(repository = repository, details = details)
            }
        }

        state<RepositoryDetailsViewState.Error> {
            interpret<RepositoryDetailsIntent.ClickTryAgain> { RepositoryDetailsAction.LoadDetails }
            process<RepositoryDetailsAction.LoadDetails> {
                result { RepositoryDetailsResult.Loading }
                sideEffect { RepositoryDetailsSideEffect.LoadDetails(repository = repository) }
            }
            reduce<RepositoryDetailsResult.Loading> { RepositoryDetailsViewState.Loading(repository = repository) }
        }
    }
)
