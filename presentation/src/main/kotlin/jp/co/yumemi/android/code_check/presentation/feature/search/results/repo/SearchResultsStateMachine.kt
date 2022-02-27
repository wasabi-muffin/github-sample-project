package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo

import android.os.Parcelable
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine

class SearchResultsStateMachine<T: Parcelable> : StateMachine<SearchResultsIntent<T>,
    SearchResultsAction<T>,
    SearchResultsResult<T>,
    SearchResultsViewState<T>,
    SearchResultsEvent<T>,
    SearchResultsSideEffect<T>>(
    builder = {
        state<SearchResultsViewState<T>> {
            interpret<SearchResultsIntent.ProcessEvent<T>> { SearchResultsAction.ProcessEvent(event = it.event) }
            process<SearchResultsAction.ProcessEvent<T>> {
                result { SearchResultsResult.ProcessEvent(event = it.event) }
            }
            interpret<SearchResultsIntent.ClickBack<T>> { SearchResultsAction.NavigateBack() }
            process<SearchResultsAction.NavigateBack<T>> {
                result { SearchResultsResult.SendEvent(SearchResultsEvent.NavigateBack()) }
            }
        }

        state<SearchResultsViewState.Initial<T>> {
            interpret<SearchResultsIntent.OnStart<T>> { SearchResultsAction.LoadSearch() }
            process<SearchResultsAction.LoadSearch<T>> {
                result { SearchResultsResult.Loading() }
                sideEffect { SearchResultsSideEffect.Search(searchText = searchText, pageNumber = 1) }
            }
            reduce<SearchResultsResult.Loading<T>> { SearchResultsViewState.Loading(searchText = searchText) }
        }

        state<SearchResultsViewState.Loading<T>> {
            reduce<SearchResultsResult.SearchSuccess<T>> {
                if (it.data.totalCount == 1) {
                    SearchResultsViewState.Empty(searchText = searchText)
                } else {
                    SearchResultsViewState.Stable.Initial(
                        searchText = searchText,
                        results = it.data.items,
                        pageNumber = 1,
                        totalCount = it.data.totalCount
                    )
                }
            }
            reduce<SearchResultsResult.SearchError<T>> { SearchResultsViewState.Error(searchText = searchText, error = it.error) }
        }

        state<SearchResultsViewState.Stable<T>> {
            interpret<SearchResultsIntent.ClickItem<T>> { SearchResultsAction.NavigateDetails(item = it.item) }
            process<SearchResultsAction.NavigateDetails<T>> {
                result { SearchResultsResult.SendEvent(event = SearchResultsEvent.NavigateDetails(item = it.item)) }
            }
        }

        state<SearchResultsViewState.Stable.Initial<T>> {
            interpret<SearchResultsIntent.PullToRefresh<T>> { SearchResultsAction.RefreshSearch() }
            interpret<SearchResultsIntent.ScrollToBottom<T>> {
                if (pageable) {
                    SearchResultsAction.PageSearch()
                } else {
                    null
                }
            }
            process<SearchResultsAction.RefreshSearch<T>> {
                result { SearchResultsResult.RefreshLoading() }
                sideEffect { SearchResultsSideEffect.Search(searchText = searchText, pageNumber = 1) }
            }
            process<SearchResultsAction.PageSearch<T>> {
                result { SearchResultsResult.PageLoading() }
                sideEffect { SearchResultsSideEffect.Search(searchText = searchText, pageNumber = pageNumber + 1) }
            }
            reduce<SearchResultsResult.RefreshLoading<T>> {
                SearchResultsViewState.Stable.RefreshLoading(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
            reduce<SearchResultsResult.PageLoading<T>> {
                SearchResultsViewState.Stable.PageLoading(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
        }

        state<SearchResultsViewState.Stable.RefreshLoading<T>> {
            reduce<SearchResultsResult.SearchSuccess<T>> {
                SearchResultsViewState.Stable.Initial(
                    searchText = searchText,
                    results = it.data.items,
                    pageNumber = 1,
                    totalCount = it.data.totalCount
                )
            }
            reduce<SearchResultsResult.SearchError<T>> {
                SearchResultsViewState.Stable.RefreshError(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount,
                    error = it.error
                )
            }
        }

        state<SearchResultsViewState.Stable.PageLoading<T>> {
            reduce<SearchResultsResult.SearchSuccess<T>> {
                SearchResultsViewState.Stable.Initial(
                    searchText = searchText,
                    results = results + it.data.items,
                    pageNumber = pageNumber + 1,
                    totalCount = it.data.totalCount
                )
            }
            reduce<SearchResultsResult.SearchError<T>> {
                SearchResultsViewState.Stable.PageError(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount,
                    error = it.error
                )
            }
        }

        state<SearchResultsViewState.Stable.RefreshError<T>> {
            interpret<SearchResultsIntent.ClickErrorOk<T>> { SearchResultsAction.ResolveError() }
            process<SearchResultsAction.ResolveError<T>> {
                result { SearchResultsResult.ResolveError() }
            }
            reduce<SearchResultsResult.ResolveError<T>> {
                SearchResultsViewState.Stable.Initial(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
        }

        state<SearchResultsViewState.Stable.PageError<T>> {
            interpret<SearchResultsIntent.ClickErrorRetry<T>> { SearchResultsAction.PageSearch() }
            interpret<SearchResultsIntent.PullToRefresh<T>> { SearchResultsAction.RefreshSearch() }
            process<SearchResultsAction.PageSearch<T>> {
                result { SearchResultsResult.PageLoading() }
                sideEffect { SearchResultsSideEffect.Search(searchText = searchText, pageNumber = pageNumber + 1) }
            }
            process<SearchResultsAction.RefreshSearch<T>> {
                result { SearchResultsResult.RefreshLoading() }
                sideEffect { SearchResultsSideEffect.Search(searchText = searchText, pageNumber = 1) }
            }
            reduce<SearchResultsResult.PageLoading<T>> {
                SearchResultsViewState.Stable.PageLoading(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
            reduce<SearchResultsResult.RefreshLoading<T>> {
                SearchResultsViewState.Stable.RefreshLoading(
                    searchText = searchText,
                    results = results,
                    pageNumber = pageNumber,
                    totalCount = totalCount
                )
            }
        }

        state<SearchResultsViewState.Error<T>> {
            interpret<SearchResultsIntent.ClickTryAgain<T>> { SearchResultsAction.LoadSearch() }
            process<SearchResultsAction.LoadSearch<T>> {
                result { SearchResultsResult.Loading() }
                sideEffect { SearchResultsSideEffect.Search(searchText = searchText, pageNumber = 1) }
            }
            reduce<SearchResultsResult.Loading<T>> { SearchResultsViewState.Loading(searchText = searchText) }
        }
    }
)
