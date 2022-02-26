package jp.co.yumemi.android.code_check.ui.components.error

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.android.code_check.ui.R
import jp.co.yumemi.android.code_check.ui.primitives.Blue
import jp.co.yumemi.android.code_check.ui.primitives.GithubTheme

@Composable
fun ErrorOkDialog(
    title: String,
    description: String? = null,
    canDismiss: Boolean = false,
    onClickOk: () -> Unit,
) = AlertDialog(
    onDismissRequest = { if (canDismiss) onClickOk() },
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
            onClick = onClickOk,
        ) {
            Text(
                text = stringResource(R.string.common_ok),
                color = Blue.v500,
            )
        }
    }
)

@Preview
@Composable
fun Preview_() {
    GithubTheme {
        ErrorOkDialog(title = "Error") {}
    }
}
