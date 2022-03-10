package io.github.gmvalentino8.github.sample.ui.components.appbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.gmvalentino8.github.sample.ui.primitives.Github
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme

@Composable
fun CommonAppBar(
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    navigationIcon: (@Composable () -> Unit)? = null,
    content: @Composable RowScope.() -> Unit
) = TopAppBar(
    modifier = modifier.fillMaxWidth(),
    backgroundColor = Github.White,
    elevation = elevation,
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
) {
    if (navigationIcon != null) {
        navigationIcon()
        Spacer(modifier = Modifier.width(16.dp))
    }
    content()
}

@Preview
@Composable
fun Preview_CommonAppBar() {
    GithubTheme {
        CommonAppBar(modifier = Modifier.background(Color.White), navigationIcon = null) {}
    }
}
