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
 * Commit Activity
 * @param days 
 * @param total 
 * @param week 
 */
@Serializable
data class CommitMinusActivityModel(
    @SerialName(value = "days")
    val days: kotlin.collections.List<kotlin.Int>,
    @SerialName(value = "total")
    val total: kotlin.Int,
    @SerialName(value = "week")
    val week: kotlin.Int
) {

}

