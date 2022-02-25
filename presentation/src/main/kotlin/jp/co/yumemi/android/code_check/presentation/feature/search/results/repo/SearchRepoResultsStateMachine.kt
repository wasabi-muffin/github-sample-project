package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo

import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchRepoResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine

class SearchRepoResultsStateMachine : StateMachine<SearchRepoResultsIntent,
    SearchRepoResultsAction,
    SearchRepoResultsResult,
    SearchRepoResultsViewState,
    SearchRepoResultsEvent,
    SearchRepoResultsSideEffect>(
    builder = {
        state<SearchRepoResultsViewState> {
            interpret<SearchRepoResultsIntent.ProcessEvent> { SearchRepoResultsAction.ProcessEvent(event = it.event) }
            process<SearchRepoResultsAction.ProcessEvent> {
                result { SearchRepoResultsResult.ProcessEvent(event = it.event) }
            }
            interpret<SearchRepoResultsIntent.ClickBack> { SearchRepoResultsAction.NavigateBack }
            process<SearchRepoResultsAction.NavigateBack> {
                result { SearchRepoResultsResult.SendEvent(SearchRepoResultsEvent.NavigateBack) }
            }
        }

        state<SearchRepoResultsViewState.Initial> {
            interpret<SearchRepoResultsIntent.OnStart> { SearchRepoResultsAction.LoadSearch }
            process<SearchRepoResultsAction.LoadSearch> {
                result { SearchRepoResultsResult.Loading }
                sideEffect { SearchRepoResultsSideEffect.Search(searchText = searchText, pageNumber = 0) }
            }
            reduce<SearchRepoResultsResult.Loading> { SearchRepoResultsViewState.Loading(searchText = searchText) }
        }

        state<SearchRepoResultsViewState.Loading> {
            reduce<SearchRepoResultsResult.SearchSuccess> {
                if (it.data.totalCount == 0) {
                    SearchRepoResultsViewState.Empty(searchText = searchText)
                } else {
                    SearchRepoResultsViewState.Stable.Initial(
                        searchText = searchText,
                        results = it.data.items,
                        pageNumber = 0,
                        totalCount = it.data.totalCount
                    )
                }
            }
            reduce<SearchRepoResultsResult.SearchError> { SearchRepoResultsViewState.Error(searchText = searchText, error = it.error) }
        }

        state<SearchRepoResultsViewState.Stable> {
            interpret<SearchRepoResultsIntent.ClickItem> { SearchRepoResultsAction.NavigateDetails(item = it.item) }
            process<SearchRepoResultsAction.NavigateDetails> {
                result { SearchRepoResultsResult.SendEvent(event = SearchRepoResultsEvent.NavigateDetails(item = it.item)) }
            }
        }

        state<SearchRepoResultsViewState.Stable.Initial> {
            interpret<SearchRepoResultsIntent.PullToRefresh> { SearchRepoResultsAction.RefreshSearch }
            interpret<SearchRepoResultsIntent.ScrollToBottom> {
                if (pageable) {
                    SearchRepoResultsAction.PageSearch
                } else {
                    null
                }
            }
            process<SearchRepoResultsAction.RefreshSearch> {
                result { SearchRepoResultsResult.RefreshLoading }
                sideEffect { SearchRepoResultsSideEffect.Search(searchText = searchText, pageNumber = 0) }
            }
            process<SearchRepoResultsAction.PageSearch> {
                result { SearchRepoResultsResult.PageLoading }
                sideEffect { SearchRepoResultsSideEffect.Search(searchText = searchText, pageNumber = pageNumber + 1) }
            }
            reduce<SearchRepoResultsResult.RefreshLoading> {
                SearchRepoResultsViewState.Stable.RefreshLoading(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
            reduce<SearchRepoResultsResult.PageLoading> {
                SearchRepoResultsViewState.Stable.PageLoading(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
        }

        state<SearchRepoResultsViewState.Stable.RefreshLoading> {
            reduce<SearchRepoResultsResult.SearchSuccess> {
                SearchRepoResultsViewState.Stable.Initial(
                    searchText = searchText,
                    results = it.data.items,
                    pageNumber = 0,
                    totalCount = it.data.totalCount
                )
            }
            reduce<SearchRepoResultsResult.SearchError> {
                SearchRepoResultsViewState.Stable.RefreshError(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount,
                    error = it.error
                )
            }
        }

        state<SearchRepoResultsViewState.Stable.PageLoading> {
            reduce<SearchRepoResultsResult.SearchSuccess> {
                SearchRepoResultsViewState.Stable.Initial(
                    searchText = searchText,
                    results = results + it.data.items,
                    pageNumber = 0,
                    totalCount = it.data.totalCount
                )
            }
            reduce<SearchRepoResultsResult.SearchError> {
                SearchRepoResultsViewState.Stable.PageError(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount,
                    error = it.error
                )
            }
        }

        state<SearchRepoResultsViewState.Stable.RefreshError> {
            interpret<SearchRepoResultsIntent.ClickErrorOk> { SearchRepoResultsAction.ResolveError }
            process<SearchRepoResultsAction.ResolveError> {
                result { SearchRepoResultsResult.ResolveError }
            }
            reduce<SearchRepoResultsResult.ResolveError> {
                SearchRepoResultsViewState.Stable.Initial(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
        }

        state<SearchRepoResultsViewState.Stable.PageError> {
            interpret<SearchRepoResultsIntent.ClickErrorRetry> { SearchRepoResultsAction.PageSearch }
            interpret<SearchRepoResultsIntent.PullToRefresh> { SearchRepoResultsAction.RefreshSearch }
            process<SearchRepoResultsAction.PageSearch> {
                result { SearchRepoResultsResult.PageLoading }
                sideEffect { SearchRepoResultsSideEffect.Search(searchText = searchText, pageNumber = pageNumber + 1) }
            }
            process<SearchRepoResultsAction.RefreshSearch> {
                result { SearchRepoResultsResult.RefreshLoading }
                sideEffect { SearchRepoResultsSideEffect.Search(searchText = searchText, pageNumber = 0) }
            }
            reduce<SearchRepoResultsResult.PageLoading> {
                SearchRepoResultsViewState.Stable.PageLoading(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
            reduce<SearchRepoResultsResult.RefreshLoading> {
                SearchRepoResultsViewState.Stable.RefreshLoading(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
        }

        state<SearchRepoResultsViewState.Error> {
            interpret<SearchRepoResultsIntent.ClickTryAgain> { SearchRepoResultsAction.LoadSearch }
            process<SearchRepoResultsAction.LoadSearch> {
                result { SearchRepoResultsResult.Loading }
                sideEffect { SearchRepoResultsSideEffect.Search(searchText = searchText, pageNumber = 0) }
            }
            reduce<SearchRepoResultsResult.Loading> { SearchRepoResultsViewState.Loading(searchText = searchText) }
        }
    }
)
