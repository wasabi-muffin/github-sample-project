package jp.co.yumemi.android.code_check.ui.features.details.repo

import android.os.Bundle
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
import jp.co.yumemi.android.code_check.presentation.core.middleware.StateSaverMiddleware
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsAction
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsEvent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsIntent
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsResult
import jp.co.yumemi.android.code_check.presentation.feature.details.repo.contract.RepoDetailsViewState
import jp.co.yumemi.android.code_check.ui.core.StoreViewModel
import jp.co.yumemi.android.code_check.ui.core.getState
import jp.co.yumemi.android.code_check.ui.core.onInit
import jp.co.yumemi.android.code_check.ui.core.saveState

class RepoDetailsViewModel @AssistedInject constructor(
    storeFactory: StoreFactory<RepoDetailsIntent, RepoDetailsAction, RepoDetailsResult, RepoDetailsViewState, RepoDetailsEvent>,
    @Assisted stateHandle: SavedStateHandle,
    @Assisted val repository: Repository
) : StoreViewModel<RepoDetailsIntent,
    RepoDetailsAction,
    RepoDetailsResult,
    RepoDetailsViewState,
    RepoDetailsEvent>(storeFactory) {
    override val store: Store<RepoDetailsIntent, RepoDetailsViewState, RepoDetailsEvent> = storeFactory.create(
        stateHandle.getState() ?: State(RepoDetailsViewState.Initial(repository)),
        middlewares = listOf(
            StateSaverMiddleware<RepoDetailsViewState, RepoDetailsEvent> { stateHandle.saveState(it) }
        )
    )

    init {
        stateHandle.onInit {
            dispatch(RepoDetailsIntent.OnStart)
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
