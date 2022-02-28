package jp.co.yumemi.android.code_check.remote.error

import android.util.Log
import io.ktor.client.features.HttpRequestTimeoutException
import io.ktor.network.sockets.ConnectTimeoutException
import io.ktor.network.sockets.SocketTimeoutException
import java.net.UnknownHostException
import jp.co.yumemi.android.code_check.data.error.DataException
import jp.co.yumemi.android.code_check.data.error.ExceptionHandler

object RemoteExceptionHandler : ExceptionHandler {
    override fun handle(throwable: Throwable): DataException {
        Log.d("ExceptionHandler", "Throwable: $throwable")
        val exception = when (throwable) {
            is ApiException.GithubApiException -> {
                when (throwable.statusCode) {
                    401 -> DataException.RemoteException.UnauthorizedException(throwable.message, throwable)
                    403 -> DataException.RemoteException.ForbiddenException(throwable.message, throwable)
                    404 -> DataException.RemoteException.NotFoundException(throwable.message, throwable)
                    422 -> DataException.RemoteException.UnprocessableException(throwable.message, throwable)
                    500 -> DataException.RemoteException.InternalServerException(throwable.message, throwable)
                    503 -> DataException.RemoteException.ServiceUnavailableException(throwable.message, throwable)
                    else -> DataException.Unknown(throwable.message, throwable)
                }
            }
            is UnknownHostException,
            is HttpRequestTimeoutException,
            is ConnectTimeoutException,
            is SocketTimeoutException -> DataException.RemoteException.NetworkException(throwable.message, throwable)
            else -> DataException.Unknown(throwable?.message, throwable)
        }
        Log.d("ExceptionHandler", "Exception $exception")
        return exception
    }
}

internal inline fun <T, R> T.runHandling(block: T.() -> R): R {
    return try {
        block()
    } catch (e: Throwable) {
        throw RemoteExceptionHandler.handle(e)
    }
}
