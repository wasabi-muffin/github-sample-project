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

import jp.co.yumemi.android.code_check.data.models.OrganizationMinusDependabotMinusSecretModel

import kotlinx.serialization.*

/**
 * 
 * @param totalCount 
 * @param secrets 
 */
@Serializable
data class InlineResponse20011Model(
    @SerialName(value = "total_count")
    val totalCount: kotlin.Int,
    @SerialName(value = "secrets")
    val secrets: kotlin.collections.List<OrganizationMinusDependabotMinusSecretModel>
) {

}
