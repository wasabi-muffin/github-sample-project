package jp.co.yumemi.android.code_check.presentation.feature.search.results.repo

import android.os.Parcelable
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsAction
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsEvent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsIntent
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsResult
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsSideEffect
import jp.co.yumemi.android.code_check.presentation.feature.search.results.repo.contract.SearchResultsViewState
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachine
import jp.co.yumemi.android.code_check.presentation.statemachine.components.StateMachineProcessor
import kotlinx.coroutines.FlowPreview

@FlowPreview
abstract class SearchResultsProcessor<T : Parcelable>(
    stateMachine: StateMachine<SearchResultsIntent<T>,
        SearchResultsAction<T>,
        SearchResultsResult<T>,
        SearchResultsViewState<T>,
        SearchResultsEvent<T>,
        SearchResultsSideEffect<T>>,
) : StateMachineProcessor<SearchResultsIntent<T>,
    SearchResultsAction<T>,
    SearchResultsResult<T>,
    SearchResultsViewState<T>,
    SearchResultsEvent<T>,
    SearchResultsSideEffect<T>>(
    stateMachine
)
