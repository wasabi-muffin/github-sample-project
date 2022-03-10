package io.github.gmvalentino8.github.sample.ui.utils

import android.content.Context
import android.widget.Toast
import io.github.gmvalentino8.github.sample.ui.R

fun notImplemented(context: Context) {
    Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show()
}
