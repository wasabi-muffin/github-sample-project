/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject
import jp.co.yumemi.android.code_check.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.code_check.data.repositories.SearchDataRepository
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.domain.core.DomainResult
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.entities.GithubRepo
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoExecutor
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase
import jp.co.yumemi.android.code_check.local.core.AppDatabase
import jp.co.yumemi.android.code_check.local.providers.SearchLocalDataProvider
import jp.co.yumemi.android.code_check.remote.apis.HttpClientSearchApi
import jp.co.yumemi.android.code_check.remote.core.DefaultHttpClientProvider
import jp.co.yumemi.android.code_check.remote.providers.SearchRemoteDataProvider
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
    fun searchResults(inputText: String): List<GithubRepo> = runBlocking {
        return@runBlocking GlobalScope.async {
            // TODO: Remove Last Search Date
            lastSearchDate = Date()
            return@async when (val items = searchRepoUseCase.execute(SearchRepoUseCase.Args(inputText))) {
                is DomainResult.Success -> items.data
                is DomainResult.Failure -> emptyList()
            }
        }.await()
    }
}
