package jp.co.yumemi.android.code_check.ui.core

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import jp.co.yumemi.android.code_check.presentation.core.contract.Event

@SuppressLint("ComposableNaming")
@Composable
fun <E : Event> E?.handle(process: (E) -> Unit, block: (E) -> Unit) {
    this?.let {
        LaunchedEffect(it) {
            block(it)
            process(it)
        }
    }
}
