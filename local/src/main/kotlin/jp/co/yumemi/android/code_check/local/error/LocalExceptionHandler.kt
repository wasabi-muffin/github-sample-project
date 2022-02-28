package jp.co.yumemi.android.code_check.local.error

import jp.co.yumemi.android.code_check.data.error.DataException
import jp.co.yumemi.android.code_check.data.error.ExceptionHandler

object LocalExceptionHandler : ExceptionHandler {
    override fun handle(throwable: Throwable): DataException {
        return DataException.LocalException.DatabaseException(throwable.message, throwable)
    }
}

internal inline fun <T, R> T.runHandling(block: T.() -> R): R {
    return try {
        block()
    } catch (e: Throwable) {
        throw LocalExceptionHandler.handle(e)
    }
}
