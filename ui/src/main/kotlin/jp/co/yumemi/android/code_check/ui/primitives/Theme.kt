package jp.co.yumemi.android.code_check.ui.primitives

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Github.DarkGray,
    primaryVariant = Github.Gray,
    secondary = Github.LightGray,
    background = Github.White,
    surface = Github.White,
    error = Red.v500,
    onPrimary = Github.White
)

@Composable
fun GithubTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
