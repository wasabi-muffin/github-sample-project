package io.github.gmvalentino8.github.sample.presentation.feature.search.top

import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopAction
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopEvent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopIntent
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopResult
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopSideEffect
import io.github.gmvalentino8.github.sample.presentation.feature.search.top.contract.SearchTopViewState
import io.github.gmvalentino8.github.sample.presentation.statemachine.components.StateMachine

class SearchTopStateMachine : StateMachine<SearchTopIntent, SearchTopAction, SearchTopResult, SearchTopViewState, SearchTopEvent, SearchTopSideEffect>(
    builder = {
        state<SearchTopViewState> {
            interpret<SearchTopIntent.ProcessEvent> { SearchTopAction.ProcessEvent(it.event) }
            interpret<SearchTopIntent.ClickBack> { SearchTopAction.NavigateBack }
            process<SearchTopAction.ProcessEvent> {
                result { SearchTopResult.ProcessEvent(it.event) }
            }
            process<SearchTopAction.NavigateBack> {
                result { SearchTopResult.SendEvent(SearchTopEvent.NavigateBack) }
            }
        }

        state<SearchTopViewState.Initial> {
            interpret<SearchTopIntent.OnStart> { SearchTopAction.LoadRecentSearches }
            process<SearchTopAction.LoadRecentSearches> {
                sideEffect { SearchTopSideEffect.LoadRecentSearches }
            }
            reduce<SearchTopResult.RecentSearches> { SearchTopViewState.Stable.EmptySearch(recentSearches = it.data) }
        }

        state<SearchTopViewState.Stable> {
            interpret<SearchTopIntent.InputSearchText> { SearchTopAction.UpdateSearchText(it.text) }
            process<SearchTopAction.UpdateSearchText> {
                result { SearchTopResult.UpdateSearchText(it.text) }
                sideEffect { if (it.text.isEmpty()) SearchTopSideEffect.LoadRecentSearches else null }
            }
        }

        state<SearchTopViewState.Stable.EmptySearch> {
            interpret<SearchTopIntent.ClickClearRecentSearches> { SearchTopAction.ClearRecentSearches }
            interpret<SearchTopIntent.ClickRecentSearchItem> { SearchTopAction.UpdateSearchText(text = it.recentSearch.searchText) }
            process<SearchTopAction.ClearRecentSearches> {
                sideEffect { SearchTopSideEffect.ClearRecentSearches }
            }
            reduce<SearchTopResult.RecentSearches> { copy(recentSearches = it.data) }
            reduce<SearchTopResult.ClearRecentSearches> { SearchTopViewState.Stable.EmptySearch(recentSearches = emptyList()) }
            reduce<SearchTopResult.UpdateSearchText> {
                SearchTopViewState.Stable.NonEmptySearch(
                    searchText = it.text,
                    recentSearches = recentSearches
                )
            }
        }

        state<SearchTopViewState.Stable.NonEmptySearch> {
            interpret<SearchTopIntent.ClickItem> { SearchTopAction.NavigateSearch(it.type) }
            interpret<SearchTopIntent.ClickClearSearchText> { SearchTopAction.UpdateSearchText("") }
            interpret<SearchTopIntent.ClickSearch> { SearchTopAction.LoadSearch }
            process<SearchTopAction.NavigateSearch> {
                result { SearchTopResult.SendEvent(SearchTopEvent.NavigateSearch(it.type, searchText)) }
            }
            process<SearchTopAction.LoadSearch> {
                result { SearchTopResult.Loading }
                sideEffect { SearchTopSideEffect.SearchAll(searchText) }
            }
            reduce<SearchTopResult.Loading> {
                SearchTopViewState.Stable.Search.Loading(
                    recentSearches = recentSearches,
                    searchText = searchText
                )
            }
            reduce<SearchTopResult.RecentSearches> { copy(recentSearches = it.data) }
            reduce<SearchTopResult.UpdateSearchText> {
                if (it.text.isEmpty()) {
                    SearchTopViewState.Stable.EmptySearch(recentSearches = recentSearches)
                } else {
                    SearchTopViewState.Stable.NonEmptySearch(
                        searchText = it.text,
                        recentSearches = recentSearches
                    )
                }
            }
        }

        state<SearchTopViewState.Stable.Search> {
            interpret<SearchTopIntent.ClickClearSearchText> { SearchTopAction.UpdateSearchText("") }
            reduce<SearchTopResult.UpdateSearchText> {
                if (it.text.isEmpty()) {
                    SearchTopViewState.Stable.EmptySearch(recentSearches = recentSearches)
                } else {
                    SearchTopViewState.Stable.NonEmptySearch(
                        searchText = it.text,
                        recentSearches = recentSearches
                    )
                }
            }
        }

        state<SearchTopViewState.Stable.Search.Loading> {
            reduce<SearchTopResult.LoadSearchSuccess> {
                SearchTopViewState.Stable.Search.Success(
                    recentSearches = recentSearches,
                    searchText = searchText,
                    searchResults = it.results
                )
            }
            reduce<SearchTopResult.LoadSearchError> {
                SearchTopViewState.Stable.Search.Error(
                    recentSearches = recentSearches,
                    searchText = searchText,
                    error = it.error
                )
            }
        }

        state<SearchTopViewState.Stable.Search.Success> {
            interpret<SearchTopIntent.ClickRepositoryResult> { SearchTopAction.NavigateRepositoryDetails(it.repository) }
            interpret<SearchTopIntent.ClickSeeAll> { SearchTopAction.NavigateSearch(it.searchType) }
            process<SearchTopAction.NavigateRepositoryDetails> {
                result { SearchTopResult.SendEvent(SearchTopEvent.NavigateRepositoryDetails(it.repository)) }
            }
            process<SearchTopAction.NavigateSearch> {
                result { SearchTopResult.SendEvent(SearchTopEvent.NavigateSearch(it.type, searchText)) }
            }
        }

        state<SearchTopViewState.Stable.Search.Error> {
            interpret<SearchTopIntent.ClickTryAgain> { SearchTopAction.LoadSearch }
            process<SearchTopAction.LoadSearch> {
                result { SearchTopResult.Loading }
                sideEffect { SearchTopSideEffect.SearchAll(searchText) }
            }
            reduce<SearchTopResult.Loading> {
                SearchTopViewState.Stable.Search.Loading(
                    recentSearches = recentSearches,
                    searchText = searchText
                )
            }
        }
    }
)
