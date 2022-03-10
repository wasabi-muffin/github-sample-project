package io.github.gmvalentino8.github.sample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.github.gmvalentino8.github.sample.remote.apis.HttpClientPullsApi
import io.github.gmvalentino8.github.sample.remote.apis.HttpClientReposApi
import io.github.gmvalentino8.github.sample.remote.apis.HttpClientSearchApi
import io.github.gmvalentino8.github.sample.remote.apis.PullsApi
import io.github.gmvalentino8.github.sample.remote.apis.ReposApi
import io.github.gmvalentino8.github.sample.remote.apis.SearchApi
import io.github.gmvalentino8.github.sample.remote.core.HttpClientProvider

@Module
@InstallIn(ActivityRetainedComponent::class)
class ApiModule {
    @Provides
    fun provideSearchApi(
        httpClientProvider: HttpClientProvider
    ): SearchApi = HttpClientSearchApi(httpClientProvider)

    @Provides
    fun provideReposApi(
        httpClientProvider: HttpClientProvider
    ): ReposApi = HttpClientReposApi(httpClientProvider)

    @Provides
    fun providePullsApi(
        httpClientProvider: HttpClientProvider
    ): PullsApi = HttpClientPullsApi(httpClientProvider)
}
