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

package io.github.gmvalentino8.github.sample.remote.models

import io.github.gmvalentino8.github.sample.remote.models.ValidationErrorErrorsApiModel

import kotlinx.serialization.*

/**
 * Validation Error
 * @param message 
 * @param documentationUrl 
 * @param errors 
 */
@Serializable
data class ValidationMinusErrorApiModel(
    @SerialName(value = "message")
    val message: kotlin.String,
    @SerialName(value = "documentation_url")
    val documentationUrl: kotlin.String,
    @SerialName(value = "errors")
    val errors: kotlin.collections.List<ValidationErrorErrorsApiModel>? = null
) {

}
