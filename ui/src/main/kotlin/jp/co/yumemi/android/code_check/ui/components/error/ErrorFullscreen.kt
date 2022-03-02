package jp.co.yumemi.android.code_check.ui.components.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Blue
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme
import jp.co.yumemi.android.code_check.ui.primitives.Gray

@Composable
fun ErrorFullscreen(
    title: String,
    modifier: Modifier = Modifier.background(Gray.v200),
    description: String? = null,
    onClickRetry: (() -> Unit)? = null,
) = Box(modifier = modifier.fillMaxSize()) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .align(Alignment.Center)
            .padding(24.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.Bold,
            color = Github.Black
        )
        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = Gray.v700
            )
        }
        if (onClickRetry != null) {
            TextButton(
                onClick = onClickRetry,
                colors = ButtonDefaults.textButtonColors(backgroundColor = Github.White),
                elevation = ButtonDefaults.elevation()
            ) {
                Text(
                    text = stringResource(R.string.common_try_again).toUpperCase(Locale.current),
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Normal,
                    color = Blue.v500,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
fun ErrorFullscreen(
    error: DomainError,
    modifier: Modifier = Modifier.background(Gray.v200),
    onClickRetry: (() -> Unit)? = null
) = ErrorFullscreen(
    title = stringResource(id = error.title()),
    description = error.description()?.let { stringResource(id = it) },
    modifier = modifier,
    onClickRetry = onClickRetry
)

@Preview
@Composable
fun Preview_ErrorFullscreen() {
    GithubTheme {
        ErrorFullscreen(title = "Error")
    }
}
