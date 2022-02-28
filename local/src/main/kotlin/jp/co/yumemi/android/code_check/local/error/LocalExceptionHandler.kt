package jp.co.yumemi.android.code_check.local.error

import jp.co.yumemi.android.code_check.data.error.DataException
import jp.co.yumemi.android.code_check.data.error.ExceptionHandler

class LocalExceptionHandler : ExceptionHandler {
    override fun handle(throwable: Throwable): DataException {
        return DataException.LocalException.DatabaseException(throwable.message, throwable)
    }
}
