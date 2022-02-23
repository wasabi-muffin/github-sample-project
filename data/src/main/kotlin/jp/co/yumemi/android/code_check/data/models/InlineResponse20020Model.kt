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

import jp.co.yumemi.android.code_check.data.models.CodespaceMinusMachineModel

import kotlinx.serialization.*

/**
 * 
 * @param totalCount 
 * @param machines 
 */
@Serializable
data class InlineResponse20020Model(
    @SerialName(value = "total_count")
    val totalCount: kotlin.Int,
    @SerialName(value = "machines")
    val machines: kotlin.collections.List<CodespaceMinusMachineModel>
) {

}

