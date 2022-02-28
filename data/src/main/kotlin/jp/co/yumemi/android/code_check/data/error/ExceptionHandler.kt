package jp.co.yumemi.android.code_check.data.error

fun interface ExceptionHandler {
    fun handle(throwable: Throwable): DataException
}

inline fun <T, R> T.runHandling(handler: ExceptionHandler, block: T.() -> R): R {
    return try {
        block()
    } catch (e: Throwable) {
        throw handler.handle(e)
    }
}
