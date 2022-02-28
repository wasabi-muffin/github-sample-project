package jp.co.yumemi.android.code_check.ui.components.search

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.components.list.CommonListItem
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme
import jp.co.yumemi.android.code_check.ui.utils.icon
import jp.co.yumemi.android.code_check.ui.utils.label

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
        SearchTypeItem(searchText = "Test", searchType = SearchType.Repo, modifier = Modifier.background(Color.White))
    }
}
