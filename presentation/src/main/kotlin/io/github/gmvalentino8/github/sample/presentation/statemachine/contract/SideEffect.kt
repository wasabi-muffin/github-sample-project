package io.github.gmvalentino8.github.sample.presentation.statemachine.contract

import io.github.gmvalentino8.github.sample.presentation.core.contract.Contract

/**
 * Side effect
 *
 * Indicates when a [StateMachine] needs to access the [StateMachineProcessor]
 */
interface SideEffect : Contract
