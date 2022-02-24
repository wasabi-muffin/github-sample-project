package jp.co.yumemi.android.code_check.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
    onClickClear: () -> Unit,
    onSearchTextChanged: (String) -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        contentPadding = PaddingValues(start = 16.dp, end = 8.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_left),
            contentDescription = "back",
            tint = Github.Black,
            modifier = Modifier
                .clickable { onClickBack() }
                .size(24.dp)
        )
        Spacer(modifier = Modifier.width(24.dp))
        TextField(
            value = searchText,
            placeholder = {
                Text(
                    text = placeholder,
                    color = Gray.v500
                )
            },
            onValueChange = onSearchTextChanged,
            singleLine = true,
            trailingIcon = {
                if (searchText.isEmpty()) {
                    Icon(
                        painter = painterResource(id = R.drawable.x),
                        contentDescription = "clear text",
                        tint = Gray.v500,
                        modifier = Modifier
                            .offset(x = 10.dp)
                            .clickable(onClick = onClickClear)
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Github.Black,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Gray.v500,
                disabledIndicatorColor = Gray.v500,
                unfocusedIndicatorColor = Gray.v500
            ),
            modifier = Modifier.weight(1F)
        )
    }
}

@Preview
@Composable
fun Preview_AppBarSearch() {
    GithubTheme {
        AppBarSearch(Modifier.background(Color.White), "Preview", "Hi", {}, {}, {})
    }
}
