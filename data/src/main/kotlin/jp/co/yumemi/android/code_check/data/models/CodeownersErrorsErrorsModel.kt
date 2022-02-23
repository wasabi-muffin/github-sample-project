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


import kotlinx.serialization.*

/**
 * 
 * @param line The line number where this errors occurs.
 * @param column The column number where this errors occurs.
 * @param kind The type of error.
 * @param message A human-readable description of the error, combining information from multiple fields, laid out for display in a monospaced typeface (for example, a command-line setting).
 * @param path The path of the file where the error occured.
 * @param source The contents of the line where the error occurs.
 * @param suggestion Suggested action to fix the error. This will usually be `null`, but is provided for some common errors.
 */
@Serializable
data class CodeownersErrorsErrorsModel(
    /* The line number where this errors occurs. */
    @SerialName(value = "line")
    val line: kotlin.Int,
    /* The column number where this errors occurs. */
    @SerialName(value = "column")
    val column: kotlin.Int,
    /* The type of error. */
    @SerialName(value = "kind")
    val kind: kotlin.String,
    /* A human-readable description of the error, combining information from multiple fields, laid out for display in a monospaced typeface (for example, a command-line setting). */
    @SerialName(value = "message")
    val message: kotlin.String,
    /* The path of the file where the error occured. */
    @SerialName(value = "path")
    val path: kotlin.String,
    /* The contents of the line where the error occurs. */
    @SerialName(value = "source")
    val source: kotlin.String? = null,
    /* Suggested action to fix the error. This will usually be `null`, but is provided for some common errors. */
    @SerialName(value = "suggestion")
    val suggestion: kotlin.String? = null
) {

}

