package io.github.gmvalentino8.github.sample.remote.core

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpResponseValidator

/**
 * Http client provider
 *
 * Providers an [HttpClient]
 */
interface HttpClientProvider {
    fun provide(): HttpClient
}

/**
 * Default http client provider
 *
 * Default implementation of [HttpClientProvider]
 */
class DefaultHttpClientProvider : HttpClientProvider {
    override fun provide() = HttpClient(Android.create()) {
        installDefaultRequest()
        installJsonSerializer()
        installLogging()
        installTimeOutConfig()
        HttpResponseValidator {
            errorValidation()
        }
    }
}
