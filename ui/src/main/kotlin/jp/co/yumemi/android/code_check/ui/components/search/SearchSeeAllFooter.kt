package jp.co.yumemi.android.code_check.ui.components.search

import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.components.list.CommonListSectionHeader
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme
import jp.co.yumemi.android.code_check.ui.primitives.Gray

@Composable
fun SearchSeeAllFooter(
    title: String,
    modifier: Modifier = Modifier,
) = CommonListSectionHeader(
    title = title,
    modifier = modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.chevron_right),
        tint = Gray.v500,
        contentDescription = "right arrow",
    )
}

@Preview
@Composable
fun Preview_SearchSeeAllFooter() {
    GithubTheme {
        SearchSeeAllFooter(title = "See all", modifier = Modifier.background(Color.White))
    }
}
