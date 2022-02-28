package jp.co.yumemi.android.code_check.ui.utils

import android.content.Context
import android.widget.Toast
import jp.co.yumemi.android.code_check.ui.R

fun notImplemented(context: Context) {
    Toast.makeText(context, context.getString(R.string.error_not_implemented), Toast.LENGTH_SHORT).show()
}
