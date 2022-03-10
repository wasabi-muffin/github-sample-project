package io.github.gmvalentino8.github.sample.ui.core

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import io.github.gmvalentino8.github.sample.presentation.core.contract.Event

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
