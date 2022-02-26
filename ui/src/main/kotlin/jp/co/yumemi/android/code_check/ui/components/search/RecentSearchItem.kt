package jp.co.yumemi.android.code_check.ui.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme
import jp.co.yumemi.android.code_check.ui.primitives.Gray

@Composable
fun RecentSearchItem(
    searchText: String,
    modifier: Modifier = Modifier,
) = Row(
    modifier = modifier.padding(horizontal = 16.dp, vertical = 20.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    Text(
        text = searchText,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Normal,
        modifier = Modifier
            .weight(1F)
            .padding(end = 16.dp)
    )
    Icon(
        painter = painterResource(id = R.drawable.arrow_up_left),
        contentDescription = "recent search",
        tint = Gray.v400,
        modifier = Modifier.size(24.dp)
    )
}

@Preview
@Composable
fun Preview_RecentSearchItem() {
    GithubTheme {
        RecentSearchItem(searchText = "Test", modifier = Modifier.background(Color.White))
    }
}
