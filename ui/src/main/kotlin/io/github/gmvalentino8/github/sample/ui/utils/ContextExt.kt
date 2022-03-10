package io.github.gmvalentino8.github.sample.ui.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme

fun Context.compose(content: @Composable Context.() -> Unit): ComposeView = ComposeView(this).apply {
    setContent {
        GithubTheme {
            content()
        }
    }
}
