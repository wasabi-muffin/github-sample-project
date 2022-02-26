package jp.co.yumemi.android.code_check.ui.utils

import jp.co.yumemi.android.code_check.ui.primitives.Blue
import jp.co.yumemi.android.code_check.ui.primitives.Github
import jp.co.yumemi.android.code_check.ui.primitives.Gray
import jp.co.yumemi.android.code_check.ui.primitives.Green
import jp.co.yumemi.android.code_check.ui.primitives.Orange
import jp.co.yumemi.android.code_check.ui.primitives.Purple
import jp.co.yumemi.android.code_check.ui.primitives.Red
import jp.co.yumemi.android.code_check.ui.primitives.Yellow

fun getLanguageColor(language: String?) = when (language) {
    "Java" -> Orange.v700
    "Shell" -> Green.v400
    "TeX" -> Green.v700
    "C" -> Gray.v700
    "JavaScript" -> Yellow.v400
    "Go" -> Blue.v300
    "C++" -> Red.v300
    "Python" -> Blue.v700
    "C#" -> Green.v500
    "Swift" -> Orange.v500
    "Koltin" -> Purple.v300
    else -> Github.Black
}
