package jp.co.yumemi.android.code_check.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.android.code_check.domain.core.ErrorHandler
import jp.co.yumemi.android.code_check.domain.repositories.SearchRepository
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoExecutor
import jp.co.yumemi.android.code_check.domain.usecases.SearchRepoUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
class DomainModule {
    @Provides
    fun provideSearchRepoUseCase(
        searchRepository: SearchRepository,
        errorHandler: ErrorHandler
    ): SearchRepoUseCase = SearchRepoExecutor(searchRepository, errorHandler)
}
