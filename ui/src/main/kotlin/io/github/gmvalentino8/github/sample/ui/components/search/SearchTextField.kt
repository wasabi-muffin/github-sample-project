package io.github.gmvalentino8.github.sample.ui.components.search

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
import io.github.gmvalentino8.github.sample.ui.R
import io.github.gmvalentino8.github.sample.ui.primitives.Github
import io.github.gmvalentino8.github.sample.ui.primitives.GithubTheme
import io.github.gmvalentino8.github.sample.ui.primitives.Gray

@Composable
fun SearchTextField(
    searchText: String,
    placeholder: String,
    onSearchTextChanged: (String) -> Unit,
    onClickClear: () -> Unit,
    onClickImeSearch: () -> Unit,
    modifier: Modifier = Modifier,
) = TextField(
    value = searchText,
    placeholder = {
        Text(
            text = placeholder,
            color = Gray.v300
        )
    },
    onValueChange = onSearchTextChanged,
    singleLine = true,
    trailingIcon = {
        if (searchText.isNotEmpty()) {
            Icon(
                painter = painterResource(id = R.drawable.x),
                contentDescription = "clear text",
                tint = Gray.v700,
                modifier = Modifier
                    .size(24.dp)
                    .offset(x = 10.dp)
                    .clickable(onClick = onClickClear)
            )
        }
    },
    keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Search
    ),
    keyboardActions = KeyboardActions(
        onSearch = { onClickImeSearch() }
    ),
    colors = TextFieldDefaults.textFieldColors(
        textColor = Github.Black,
        backgroundColor = Color.Transparent,
        focusedIndicatorColor = Gray.v300,
        disabledIndicatorColor = Gray.v300,
        unfocusedIndicatorColor = Gray.v300
    ),
    modifier = modifier
)

@Preview
@Composable
fun Preview_SearchTextField() {
    GithubTheme {
        SearchTextField(searchText = "", placeholder = "", onSearchTextChanged = {}, onClickClear = { }, onClickImeSearch = { })
    }
}
