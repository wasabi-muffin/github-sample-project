package jp.co.yumemi.android.code_check.presentation.feature.search.top

import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopAction
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopResult
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.top.contract.SearchTopViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine

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
            }
        }

        state<SearchTopViewState.Stable.EmptySearch> {
            interpret<SearchTopIntent.ClickClearRecentSearches> { SearchTopAction.ClearRecentSearches }
            interpret<SearchTopIntent.ClickRecentSearchItem> { SearchTopAction.UpdateSearchText(text = it.recentSearch.searchText) }
            process<SearchTopAction.ClearRecentSearches> {
                sideEffect { SearchTopSideEffect.ClearRecentSearches }
            }
            reduce<SearchTopResult.ClearRecentSearches> { SearchTopViewState.Stable.EmptySearch(recentSearches = emptyList()) }
            reduce<SearchTopResult.UpdateSearchText> { SearchTopViewState.Stable.NonEmptySearch(searchText = it.text, recentSearches = recentSearches) }
        }

        state<SearchTopViewState.Stable.NonEmptySearch> {
            interpret<SearchTopIntent.ClickItem> { SearchTopAction.NavigateSearch(it.type) }
            interpret<SearchTopIntent.ClickClearSearchText> { SearchTopAction.UpdateSearchText("") }
            process<SearchTopAction.NavigateSearch> {
                result { SearchTopResult.SendEvent(SearchTopEvent.NavigateSearch(it.type)) }
            }
            reduce<SearchTopResult.UpdateSearchText> {
                if (it.text.isEmpty()) {
                    SearchTopViewState.Stable.EmptySearch(recentSearches = recentSearches)
                } else {
                    SearchTopViewState.Stable.NonEmptySearch(searchText = it.text, recentSearches = recentSearches)
                }
            }
        }
    }
)
