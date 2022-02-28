package jp.co.yumemi.android.code_check.remote.core

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.HttpResponseValidator

interface HttpClientProvider {
    fun provide(): HttpClient
}

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
