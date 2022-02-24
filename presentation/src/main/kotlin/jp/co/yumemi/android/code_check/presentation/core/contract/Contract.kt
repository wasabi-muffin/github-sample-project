package jp.co.yumemi.android.code_check.presentation.core.contract

import android.os.Parcelable

interface Contract

/**
 * Models any form of user interaction
 */
interface Intent : Contract

/**
 * Defines logic that should be executed by a processor
 */
interface Action : Contract

/**
 * Result from a processor
 */
interface Result : Contract

/**
 * Describes the state of the view
 */
interface ViewState : Contract, Parcelable
