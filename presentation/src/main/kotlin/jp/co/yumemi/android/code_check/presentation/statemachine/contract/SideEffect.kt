package jp.co.yumemi.android.code_check.presentation.statemachine.contract

import jp.co.yumemi.android.code_check.presentation.core.contract.Contract

/**
 * Side effect
 *
 * Indicates when a [StateMachine] needs to access the [StateMachineProcessor]
 */
interface SideEffect : Contract
