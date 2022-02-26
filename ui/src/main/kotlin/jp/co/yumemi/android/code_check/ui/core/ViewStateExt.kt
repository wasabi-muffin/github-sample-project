package jp.co.yumemi.android.code_check.ui.core

import androidx.compose.runtime.Composable
import jp.co.yumemi.android.code_check.presentation.core.contract.ViewState

@Composable
inline fun <reified VS : ViewState> ViewState?.render(block: @Composable (VS) -> Unit) {
    if (this is VS) {
        block(this)
    }
}
