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

import jp.co.yumemi.android.code_check.data.models.RepoMinusSearchMinusResultMinusItemModel

import kotlinx.serialization.*

/**
 * 
 * @param totalCount 
 * @param incompleteResults 
 * @param items 
 */
@Serializable
data class InlineResponse20028Model(
    @SerialName(value = "total_count")
    val totalCount: kotlin.Int,
    @SerialName(value = "incomplete_results")
    val incompleteResults: kotlin.Boolean,
    @SerialName(value = "items")
    val items: kotlin.collections.List<RepoMinusSearchMinusResultMinusItemModel>
) {

}

