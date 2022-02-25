package jp.co.yumemi.android.code_check.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

@Composable
fun CommonAppBar(
    modifier: Modifier = Modifier,
    navigationIcon: (@Composable () -> Unit)? = null,
    content: @Composable RowScope.() -> Unit
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = Github.White,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
    ) {
        navigationIcon?.invoke()
        Spacer(modifier = Modifier.width(16.dp))
        content()
    }
}

@Preview
@Composable
fun Preview_CommonAppBar() {
    GithubTheme {
        CommonAppBar(modifier = Modifier.background(Color.White), navigationIcon = null) {}
    }
}
