package jp.co.yumemi.android.code_check.ui.components.search

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.components.list.CommonListSectionHeader
import jp.co.yumemi.android.code_check.ui.primitives.Blue
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

@Composable
fun RecentSearchHeader(
    onClickClear: () -> Unit,
    modifier: Modifier = Modifier
) = CommonListSectionHeader(
    title = stringResource(R.string.search_top_recent_searches),
    modifier = modifier
) {
    Text(
        text = stringResource(R.string.common_clear).toUpperCase(Locale.current),
        style = MaterialTheme.typography.h4,
        color = Blue.v500,
        modifier = Modifier.clickable { onClickClear() }
    )
}

@Preview
@Composable
fun Preview_RecentSearchHeader() {
    GithubTheme {
        RecentSearchHeader(onClickClear = {})
    }
}
