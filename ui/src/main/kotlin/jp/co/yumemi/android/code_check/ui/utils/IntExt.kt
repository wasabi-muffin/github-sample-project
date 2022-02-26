package jp.co.yumemi.android.code_check.ui.utils

fun Int.toDoubleDigitString() = if (this < 100) {
    toString()
} else {
    "99+"
}

fun Int.toShortedString() = when {
    this < 1000 -> toString()
    mod(1000) < 100 -> "${this / 1000}k"
    else -> "%.1fk".format(this / 1000f)
}
