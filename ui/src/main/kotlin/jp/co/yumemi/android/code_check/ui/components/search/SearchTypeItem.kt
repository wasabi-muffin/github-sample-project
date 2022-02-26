package jp.co.yumemi.android.code_check.ui.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import jp.co.yumemi.android.code_check.domain.entities.SearchType
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

@Composable
fun SearchTypeItem(
    searchText: String,
    searchType: SearchType,
    modifier: Modifier = Modifier
) = Row(
    modifier = modifier.padding(24.dp),
    verticalAlignment = Alignment.CenterVertically
) {
    val searchTypeIconId = when (searchType) {
        SearchType.Repo -> R.drawable.repo
    }
    val searchTypeLabelId = when (searchType) {
        SearchType.Repo -> R.string.common_repositories
    }
    Icon(
        painter = painterResource(id = searchTypeIconId),
        contentDescription = "",
        tint = Github.Black,
        modifier = Modifier.size(24.dp)
    )
    Spacer(modifier = Modifier.width(16.dp))
    Text(
        text = stringResource(id = R.string.search_top_search_with, stringResource(id = searchTypeLabelId), "\"$searchText\""),
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Normal,
        modifier = Modifier.weight(1F)
    )
}

@Preview
@Composable
fun Preview_SearchTypeItem() {
    GithubTheme {
        SearchTypeItem(searchText = "Test", searchType = SearchType.Repo, modifier = Modifier.background(Color.White))
    }
}
