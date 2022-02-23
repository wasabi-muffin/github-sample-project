/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check

import androidx.lifecycle.ViewModel
import java.util.Date
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
class OneViewModel(
    database: AppDatabase
) : ViewModel() {
    // TODO: DI
    private val httpClientProvider = DefaultHttpClientProvider()
    private val searchApi = HttpClientSearchApi(httpClientProvider)
    private val searchRemoteDataSource = SearchRemoteDataProvider(searchApi)
    private val localDataSource = SearchLocalDataProvider(database.searchDao())
    private val searchRepository = SearchDataRepository(searchRemoteDataSource, localDataSource)
    private val errorHandler = ErrorHandler { throwable -> DomainError.Unknown(throwable) }
    private val searchRepoUseCase = SearchRepoExecutor(searchRepository, errorHandler)

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
