package jp.co.yumemi.android.code_check.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Blue
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

@Composable
fun RecentSearchHeader(
    onClickClear: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(all = 16.dp)) {
        Text(
            text = stringResource(R.string.search_top_recent_searches),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1F)
        )
        Text(
            text = stringResource(R.string.common_clear).toUpperCase(Locale.current),
            style = MaterialTheme.typography.h4,
            color = Blue.v500,
            modifier = Modifier.clickable { onClickClear() }
        )
    }
}

@Preview
@Composable
fun Preview_RecentSearchHeader() {
    GithubTheme {
        RecentSearchHeader({})
    }
}
