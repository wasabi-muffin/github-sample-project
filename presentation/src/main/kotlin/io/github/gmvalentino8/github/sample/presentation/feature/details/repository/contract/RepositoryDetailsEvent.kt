package io.github.gmvalentino8.github.sample.presentation.feature.details.repository.contract

import io.github.gmvalentino8.github.sample.presentation.core.contract.Event
import kotlinx.parcelize.Parcelize

sealed class RepositoryDetailsEvent : Event() {
    @Parcelize object NavigateBack : RepositoryDetailsEvent()
}
