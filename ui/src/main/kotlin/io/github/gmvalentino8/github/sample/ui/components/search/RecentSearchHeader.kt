package io.github.gmvalentino8.github.sample.ui.components.search

import androidx.compose.foundation.clickable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.components.list.CommonListSectionHeader
import io.github.gmvalentino8.github.sample.ui.primitives.Blue
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme

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
