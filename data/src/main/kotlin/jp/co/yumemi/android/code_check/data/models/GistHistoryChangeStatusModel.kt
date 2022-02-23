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
 * @param total 
 * @param additions 
 * @param deletions 
 */
@Serializable
data class GistHistoryChangeStatusModel(
    @SerialName(value = "total")
    val total: kotlin.Int? = null,
    @SerialName(value = "additions")
    val additions: kotlin.Int? = null,
    @SerialName(value = "deletions")
    val deletions: kotlin.Int? = null
) {

}

