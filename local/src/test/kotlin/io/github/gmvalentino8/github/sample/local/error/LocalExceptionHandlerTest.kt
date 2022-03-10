package io.github.gmvalentino8.github.sample.local.error

import io.kotest.matchers.shouldBe
import io.github.gmvalentino8.github.sample.data.core.DataException
import io.github.gmvalentino8.github.sample.local.core.LocalExceptionHandler
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
