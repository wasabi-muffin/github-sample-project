package jp.co.yumemi.android.code_check.ui.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

fun Context.compose(content: @Composable Context.() -> Unit): ComposeView = ComposeView(this).apply {
    setContent {
        GithubTheme {
            content()
        }
    }
}
