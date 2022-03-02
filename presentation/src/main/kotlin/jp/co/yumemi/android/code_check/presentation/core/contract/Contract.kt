package jp.co.yumemi.android.code_check.presentation.core.contract

import android.os.Parcelable

interface Contract

/**
 * Intent
 *
 * Models any form of user interaction
 */
interface Intent : Contract

/**
 * Action
 *
 * Defines logic that should be executed by a processor
 */
interface Action : Contract

/**
 * Result
 *
 * Result from a processor
 */
interface Result : Contract

/**
 * ViewState
 *
 * Describes the state of the view
 */
interface ViewState : Contract, Parcelable
