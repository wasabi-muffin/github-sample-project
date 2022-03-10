package io.github.gmvalentino8.github.sample.local.core

import io.github.gmvalentino8.github.sample.data.core.DataException
import io.github.gmvalentino8.github.sample.data.core.ExceptionHandler

class LocalExceptionHandler : ExceptionHandler {
    override fun handle(throwable: Throwable): DataException {
        return DataException.LocalException.DatabaseException(throwable.message, throwable)
    }
}
