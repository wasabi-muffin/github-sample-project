package jp.co.yumemi.android.code_check.data.error

fun interface ExceptionHandler {
    fun handle(throwable: Throwable): DataException
}
