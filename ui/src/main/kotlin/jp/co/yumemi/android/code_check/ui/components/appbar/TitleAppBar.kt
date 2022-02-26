package jp.co.yumemi.android.code_check.ui.components.appbar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.ui.primitives.Github

@Composable
fun TitleAppBar(
    title: String,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    navigationIcon: (@Composable () -> Unit)? = null,
) = CommonAppBar(
    navigationIcon = navigationIcon,
    elevation = elevation,
    modifier = modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.h2,
        fontWeight = FontWeight.Bold,
        color = Github.Black,
        modifier = Modifier.weight(1f)
    )
}
