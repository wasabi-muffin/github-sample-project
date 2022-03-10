package io.github.gmvalentino8.github.sample.ui.features.details.repo

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.presentation.core.components.Store
import io.github.gmvalentino8.github.sample.presentation.core.contract.State
import io.github.gmvalentino8.github.sample.presentation.core.factory.StoreFactory
import io.github.gmvalentino8.github.sample.presentation.core.middleware.LoggingMiddleware
import io.github.gmvalentino8.github.sample.presentation.core.middleware.StateSaverMiddleware
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsAction
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsEvent
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsIntent
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsResult
import io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract.RepositoryDetailsViewState
import io.github.gmvalentino8.github.sample.ui.core.StoreViewModel
import io.github.gmvalentino8.github.sample.ui.core.getState
import io.github.gmvalentino8.github.sample.ui.core.onInit
import io.github.gmvalentino8.github.sample.ui.core.saveState

class RepoDetailsViewModel @AssistedInject constructor(
    storeFactory: StoreFactory<RepositoryDetailsIntent, RepositoryDetailsAction, RepositoryDetailsResult, RepositoryDetailsViewState, RepositoryDetailsEvent>,
    @Assisted stateHandle: SavedStateHandle,
    @Assisted val repository: Repository
) : StoreViewModel<RepositoryDetailsIntent,
    RepositoryDetailsAction,
    RepositoryDetailsResult,
    RepositoryDetailsViewState,
    RepositoryDetailsEvent>(storeFactory) {
    override val store: Store<RepositoryDetailsIntent, RepositoryDetailsViewState, RepositoryDetailsEvent> = storeFactory.create(
        stateHandle.getState() ?: State(RepositoryDetailsViewState.Initial(repository)),
        middlewares = listOf(
            StateSaverMiddleware<RepositoryDetailsViewState, RepositoryDetailsEvent> { stateHandle.saveState(it) },
            LoggingMiddleware<RepositoryDetailsIntent, RepositoryDetailsAction, RepositoryDetailsResult, RepositoryDetailsViewState, RepositoryDetailsEvent> {
                Log.d("RepoDetails", it)
            },
        )
    )

    init {
        stateHandle.onInit {
            dispatch(RepositoryDetailsIntent.OnStart)
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            savedStateHandle: SavedStateHandle,
            repository: Repository,
        ): RepoDetailsViewModel
    }

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun provideFactory(
            assistedFactory: Factory,
            owner: SavedStateRegistryOwner,
            arguments: Bundle?,
            repository: Repository,
        ): AbstractSavedStateViewModelFactory = object : AbstractSavedStateViewModelFactory(owner, arguments) {
            override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T =
                assistedFactory.create(handle, repository) as T
        }
    }
}
