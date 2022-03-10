package io.github.gmvalentino8.github.sample.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.github.gmvalentino8.github.sample.data.core.DefaultErrorHandler
import io.github.gmvalentino8.github.sample.data.utils.InstantProvider
import io.github.gmvalentino8.github.sample.domain.core.ErrorHandler
import io.github.gmvalentino8.github.sample.local.core.AppDatabase
import io.github.gmvalentino8.github.sample.remote.core.DefaultHttpClientProvider
import io.github.gmvalentino8.github.sample.remote.core.HttpClientProvider
import kotlinx.datetime.Clock

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideErrorHandler(): ErrorHandler = DefaultErrorHandler()

    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context,
    ): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()

    @Provides
    fun provideHttpClientProvider(): HttpClientProvider = DefaultHttpClientProvider()

    @Provides
    fun provideInstantProvider(): InstantProvider = InstantProvider { Clock.System.now() }
}
