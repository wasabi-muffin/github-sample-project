package jp.co.yumemi.android.code_check.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import jp.co.yumemi.android.code_check.ui.R

@Composable
fun Int.toDoubleDigitString() = if (this < 100) {
    toString()
} else {
    stringResource(R.string.common_over_99)
}

@Composable
fun Int.toShortedString(): String {
    val thousand = stringResource(R.string.common_unit_thousands)
    val million = stringResource(R.string.common_unit_millions)
    return when {
        this < 1_000 -> toString()
        this < 1_000_000 && mod(1_000) < 50 -> "${this / 1000}$thousand"
        this < 1_000_000 -> "${stringResource(R.string.common_single_decimal_format, this / 1_000f)}$thousand"
        mod(1_000_000) < 50_000 -> "${this / 1_000_000}$million"
        else -> "${stringResource(R.string.common_single_decimal_format, this / 1_000_000f)}$million"
    }
}
