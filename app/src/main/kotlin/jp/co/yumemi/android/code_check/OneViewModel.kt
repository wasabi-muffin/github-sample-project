/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject
import jp.co.yumemi.android.code_check.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.entities.SimpleGithubRepo
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/**
 * TwoFragment で使う
 */
@HiltViewModel
class OneViewModel @Inject constructor(
    private val searchRepoUseCase: SearchRepoUseCase
) : ViewModel() {

    // 検索結果
    // TODO: Remove runBlocking and GlobalScope
    fun searchResults(inputText: String): List<SimpleGithubRepo> = runBlocking {
        return@runBlocking GlobalScope.async {
            // TODO: Remove Last Search Date
            lastSearchDate = Date()
            return@async when (val result = searchRepoUseCase.execute(SearchRepoUseCase.Args(inputText, 0))) {
                is DomainResult.Success -> result.data.items
                is DomainResult.Failure -> emptyList()
            }
        }.await()
    }
}
