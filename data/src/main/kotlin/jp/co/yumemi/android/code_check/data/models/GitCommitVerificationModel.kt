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
 * @param verified 
 * @param reason 
 * @param signature 
 * @param payload 
 */
@Serializable
data class GitCommitVerificationModel(
    @SerialName(value = "verified")
    val verified: kotlin.Boolean,
    @SerialName(value = "reason")
    val reason: kotlin.String,
    @SerialName(value = "signature")
    val signature: kotlin.String?,
    @SerialName(value = "payload")
    val payload: kotlin.String?
) {

}

