package jp.co.yumemi.android.code_check.presentation.core.contract

import android.os.Parcelable
import java.util.UUID

/**
 * Event
 *
 * One-time effects for the client (i.e. navigation, snackbars, animation)
 */
abstract class Event : Parcelable {
    val id: String = UUID.randomUUID().toString()
}

interface ProcessEventIntent<E : Event> : Intent {
    val event: E
}

interface ProcessEventAction<E : Event> : Action {
    val event: E
}

interface ProcessEventResult<E : Event> : Result {
    val event: E
}

interface SendEventResult<E : Event> : Result {
    val event: E
}
