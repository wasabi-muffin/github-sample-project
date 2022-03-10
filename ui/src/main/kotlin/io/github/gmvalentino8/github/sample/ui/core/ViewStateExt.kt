package io.github.gmvalentino8.github.sample.ui.core

import androidx.compose.runtime.Composable
import io.github.gmvalentino8.github.sample.presentation.core.contract.ViewState

@Composable
inline fun <reified VS : ViewState> ViewState?.render(block: @Composable (VS) -> Unit) {
    if (this is VS) {
        block(this)
    }
}
