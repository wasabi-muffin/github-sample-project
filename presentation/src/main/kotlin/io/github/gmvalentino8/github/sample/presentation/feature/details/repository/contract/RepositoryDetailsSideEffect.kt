package io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract

import io.github.gmvalentino8.github.sample.domain.entities.Repository
import io.github.gmvalentino8.github.sample.presentation.statemachine.contract.SideEffect

sealed class RepositoryDetailsSideEffect : SideEffect {
    data class LoadDetails(val repository: Repository) : RepositoryDetailsSideEffect()
}
