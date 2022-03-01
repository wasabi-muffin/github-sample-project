package jp.co.yumemi.android.code_check.remote.core

import android.util.Log
import io.ktor.client.HttpClientConfig
import io.ktor.client.features.HttpCallValidator
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.ResponseException
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.header
import io.ktor.client.request.host
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import jp.co.yumemi.android.code_check.remote.models.BasicMinusErrorApiModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

fun HttpClientConfig<*>.installJsonSerializer() = install(JsonFeature) {
    serializer = KotlinxSerializer(json)
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
        logger = object : Logger {
            override fun log(message: String) {
                Log.d("Ktor", message)
            }
        }
    }
}

fun HttpCallValidator.Config.errorValidation() {
    handleResponseException { e ->
        if (e is ResponseException) {
            e.response.parse<BasicMinusErrorApiModel>().run {
                throw ApiException.GithubApiException(
                    statusCode = e.response.status.value,
                    message = message,
                    cause = e
                )
            }
        }
    }
}

private suspend inline fun <reified R> HttpResponse.parse(): R =
    json.decodeFromString(serializer(), this.readText())

private val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
    encodeDefaults = false
    useAlternativeNames = false
}
