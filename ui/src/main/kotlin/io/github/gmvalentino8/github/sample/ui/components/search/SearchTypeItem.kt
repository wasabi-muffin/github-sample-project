package io.github.gmvalentino8.github.sample.ui.components.search

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.gmvalentino8.github.sample.domain.entities.SearchType
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.components.list.CommonListItem
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme
import io.github.gmvalentino8.github.sample.ui.utils.icon
import io.github.gmvalentino8.github.sample.ui.utils.label

@Composable
fun SearchTypeItem(
    searchText: String,
    searchType: SearchType,
    modifier: Modifier = Modifier
) = CommonListItem(
    icon = searchType.icon(),
    title = if (searchType == SearchType.JumpTo) {
        stringResource(id = R.string.search_top_jump_to, "\"$searchText\"")
    } else {
        searchType.label()?.let {
            stringResource(id = R.string.search_top_search_with, stringResource(id = it), "\"$searchText\"")
        } ?: ""
    },
    modifier = modifier
)

@Preview
@Composable
fun Preview_SearchTypeItem() {
    GithubTheme {
        SearchTypeItem(searchText = "Test", searchType = SearchType.Repository, modifier = Modifier.background(Color.White))
    }
}
