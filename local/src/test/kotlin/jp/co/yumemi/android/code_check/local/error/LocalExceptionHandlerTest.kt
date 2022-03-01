package jp.co.yumemi.android.code_check.local.error

import io.kotest.matchers.shouldBe
import jp.co.yumemi.android.code_check.data.core.DataException
import org.junit.Test

class LocalExceptionHandlerTest {
    private val localExceptionHandler = LocalExceptionHandler()
    private val textException = Exception("test")

    @Test
    fun `test local exception handler`() {
        val exception = localExceptionHandler.handle(textException)
        exception shouldBe DataException.LocalException.DatabaseException(message = textException.message, cause = textException)
    }
}
