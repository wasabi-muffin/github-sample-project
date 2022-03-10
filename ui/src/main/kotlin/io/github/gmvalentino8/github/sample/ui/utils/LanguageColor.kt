package io.github.gmvalentino8.github.sample.ui.utils

import io.github.gmvalentino8.github.sample.ui.primitives.Blue
import io.github.gmvalentino8.github.sample.ui.primitives.Github
import io.github.gmvalentino8.github.sample.ui.primitives.Gray
import io.github.gmvalentino8.github.sample.ui.primitives.Green
import io.github.gmvalentino8.github.sample.ui.primitives.Orange
import io.github.gmvalentino8.github.sample.ui.primitives.Purple
import io.github.gmvalentino8.github.sample.ui.primitives.Red
import io.github.gmvalentino8.github.sample.ui.primitives.Yellow

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
