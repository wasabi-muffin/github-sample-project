package io.github.gmvalentino8.github.sample.ui.components.appbar

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.github.gmvalentino8.github.sample.ui.components.search.SearchTextField
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme

@Composable
fun AppBarSearch(
    modifier: Modifier = Modifier,
    placeholder: String,
    searchText: String,
    onClickBack: () -> Unit,
    onClickImeSearch: () -> Unit,
    onClickClear: () -> Unit,
    onSearchTextChanged: (String) -> Unit,
) = CommonAppBar(
    modifier = modifier,
    navigationIcon = null,
) {
    SearchTextField(
        searchText = searchText,
        placeholder = placeholder,
        onSearchTextChanged = onSearchTextChanged,
        onClickClear = onClickClear,
        onClickImeSearch = onClickImeSearch,
        modifier = Modifier.weight(1F)
    )
}

@Preview
@Composable
fun Preview_AppBarSearch() {
    GithubTheme {
        AppBarSearch(
            modifier = Modifier.background(Color.White),
            placeholder = "Preview",
            searchText = "Hi",
            onClickBack = {},
            onClickImeSearch = {},
            onClickClear = {},
            onSearchTextChanged = {}
        )
    }
}
