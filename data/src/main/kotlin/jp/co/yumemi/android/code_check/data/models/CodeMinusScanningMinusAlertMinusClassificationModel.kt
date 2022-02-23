/**
 * GitHub v3 REST API
 *
 * GitHub's v3 REST API.
 *
 * The version of the OpenAPI document: 1.1.4
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package jp.co.yumemi.android.code_check.data.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A classification of the file. For example to identify it as generated.
 *
 * Values: source,generated,test,library
 */
@Serializable
enum class CodeMinusScanningMinusAlertMinusClassificationModel(val value: kotlin.String) {

    @SerialName(value = "source")
    source("source"),

    @SerialName(value = "generated")
    generated("generated"),

    @SerialName(value = "test")
    test("test"),

    @SerialName(value = "library")
    library("library");

    /**
     * Override toString() to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): String = value

    companion object {
        /**
         * Converts the provided [data] to a [String] on success, null otherwise.
         */
        fun encode(data: Any?): kotlin.String? = if (data is CodeMinusScanningMinusAlertMinusClassificationModel) "$data" else null

        /**
         * Returns a valid [CodeMinusScanningMinusAlertMinusClassificationModel] for [data], null otherwise.
         */
        fun decode(data: Any?): CodeMinusScanningMinusAlertMinusClassificationModel? = data?.let {
          val normalizedData = "$it".lowercase()
          values().firstOrNull { value ->
            it == value || normalizedData == "$value".lowercase()
          }
        }
    }
}
