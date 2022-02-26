package jp.co.yumemi.android.code_check.ui.core

import androidx.compose.foundation.ScrollState
import androidx.compose.ui.unit.dp

val ScrollState.isAtTop get() = this.value == 0
val ScrollState.elevation get() = if (isAtTop) 0.dp else 4.dp
