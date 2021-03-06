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


import kotlinx.serialization.*

/**
 * Email
 * @param email 
 * @param primary 
 * @param verified 
 * @param visibility 
 */
@Serializable
data class EmailApiModel(
    @SerialName(value = "email")
    val email: kotlin.String,
    @SerialName(value = "primary")
    val primary: kotlin.Boolean,
    @SerialName(value = "verified")
    val verified: kotlin.Boolean,
    @SerialName(value = "visibility")
    val visibility: kotlin.String?
) {

}

