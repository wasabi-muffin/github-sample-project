package jp.co.yumemi.android.code_check.ui.components.error

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.android.code_check.domain.core.DomainError
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Blue
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

@Composable
fun ErrorRetryDialog(
    title: String,
    onClickRetry: () -> Unit,
    onClickCancel: () -> Unit,
    description: String? = null,
    canDismiss: Boolean = false,
) = AlertDialog(
    onDismissRequest = { if (canDismiss) onClickCancel() },
    title = {
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold
        )
    },
    text = {
        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Normal
            )
        }
    },
    confirmButton = {
        TextButton(
            onClick = onClickRetry,
        ) {
            Text(
                text = stringResource(R.string.common_retry),
                color = Blue.v500,
            )
        }
    },
    dismissButton = {
        TextButton(
            onClick = onClickCancel,
        ) {
            Text(
                text = stringResource(R.string.common_cancel)
            )
        }
    }
)

@Composable
fun ErrorRetryDialog(
    error: DomainError,
    description: String? = null,
    canDismiss: Boolean = false,
    onClickRetry: () -> Unit,
    onClickCancel: () -> Unit,
) = ErrorRetryDialog(
    title = stringResource(id = error.title()),
    description = error.description()?.let { stringResource(id = it) },
    canDismiss = canDismiss,
    onClickRetry = onClickRetry,
    onClickCancel = onClickCancel
)

@Preview
@Composable
fun Preview_ErrorRetryDialog() {
    GithubTheme {
        ErrorRetryDialog(title = "Error", onClickRetry = {}, onClickCancel = {})
    }
}
