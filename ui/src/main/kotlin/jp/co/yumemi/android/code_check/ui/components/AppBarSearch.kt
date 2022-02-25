package jp.co.yumemi.android.code_check.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme
import jp.co.yumemi.android.code_check.ui.primitives.Gray

@Composable
fun AppBarSearch(
    modifier: Modifier = Modifier,
    placeholder: String,
    searchText: String,
    onClickBack: () -> Unit,
    onClickImeSearch: () -> Unit,
    onClickClear: () -> Unit,
    onSearchTextChanged: (String) -> Unit,
) {
    CommonAppBar(
        modifier = modifier,
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.arrow_left),
                contentDescription = "back",
                tint = Github.Black,
                modifier = Modifier
                    .clickable { onClickBack() }
                    .size(24.dp)
            )
        },
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
            onSearchTextChanged = {})
    }
}
