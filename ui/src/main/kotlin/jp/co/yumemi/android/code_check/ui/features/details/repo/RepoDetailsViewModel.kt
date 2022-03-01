package jp.co.yumemi.android.code_check.ui.features.details.repo

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import jp.co.yumemi.android.code_check.domain.entities.Repository
import jp.co.yumemi.android.code_check.presentation.core.components.Store
import jp.co.yumemi.android.code_check.presentation.core.contract.State
import jp.co.yumemi.android.code_check.presentation.core.factory.StoreFactory
import jp.co.yumemi.android.code_check.presentation.core.middleware.LoggingMiddleware
import jp.co.yumemi.android.code_check.presentation.core.middleware.StateSaverMiddleware
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repository.contract.RepositoryDetailsViewState
import jp.co.yumemi.android.code_check.ui.core.StoreViewModel
import jp.co.yumemi.android.code_check.ui.core.getState
import jp.co.yumemi.android.code_check.ui.core.onInit
import jp.co.yumemi.android.code_check.ui.core.saveState

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
