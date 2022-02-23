package jp.co.yumemi.android.code_check.remote.core

import io.ktor.client.HttpClientConfig
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.request.host
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import kotlinx.serialization.json.Json

fun HttpClientConfig<*>.installJsonSerializer() = install(JsonFeature) {
    serializer = KotlinxSerializer(
        Json {
            isLenient = true
            ignoreUnknownKeys = true
            encodeDefaults = false
            useAlternativeNames = false
        }
    )
    accept(ContentType.Application.Json)
}

fun HttpClientConfig<*>.installTimeOutConfig() = install(HttpTimeout) {
    requestTimeoutMillis = 50000
    connectTimeoutMillis = 50000
    socketTimeoutMillis = 50000
}

fun HttpClientConfig<*>.installDefaultRequest() = defaultRequest {
    header(HttpHeaders.ContentType, ContentType.Application.Json.toString())
    header(HttpHeaders.Connection, "close") // to avoid java.io.IOException
    host = "api.github.com"
    url { protocol = URLProtocol.HTTPS }
}

fun HttpClientConfig<*>.installLogging() {
    install(Logging) {
        level = LogLevel.ALL
        logger = Logger.DEFAULT
    }
}
