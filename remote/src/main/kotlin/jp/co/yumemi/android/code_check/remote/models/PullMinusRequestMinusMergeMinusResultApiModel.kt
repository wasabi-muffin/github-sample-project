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

package jp.co.yumemi.android.code_check.remote.models


import kotlinx.serialization.*

/**
 * Pull Request Merge Result
 * @param sha 
 * @param merged 
 * @param message 
 */
@Serializable
data class PullMinusRequestMinusMergeMinusResultApiModel(
    @SerialName(value = "sha")
    val sha: kotlin.String,
    @SerialName(value = "merged")
    val merged: kotlin.Boolean,
    @SerialName(value = "message")
    val message: kotlin.String
) {

}
