package jp.co.yumemi.android.code_check.ui.components.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

@Composable
fun CommonListSectionHeader(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit = {}
) = Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    modifier = modifier.padding(all = 16.dp)
) {
    Text(
        text = title,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.weight(1F)
    )
    content()
}

@Preview
@Composable
fun Preview_CommonHeader() {
    GithubTheme {
        CommonListSectionHeader("title")
    }
}
