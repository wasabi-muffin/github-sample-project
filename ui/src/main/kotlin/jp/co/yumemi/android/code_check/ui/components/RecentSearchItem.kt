package jp.co.yumemi.android.code_check.ui.components

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme
import jp.co.yumemi.android.code_check.ui.primitives.Gray

@Composable
fun RecentSearchItem(
    modifier: Modifier,
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.search_top_recent_searches),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.weight(1F)
        )
        Icon(
            painter = painterResource(id = R.drawable.arrow_up_left),
            contentDescription = "recent search",
            tint = Gray.v500,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
fun Preview_RecentSearchItem() {
    GithubTheme {
        RecentSearchItem(Modifier.background(Color.White))
    }
}
