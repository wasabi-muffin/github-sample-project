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
 * @param id 
 * @param nodeId 
 * @param url 
 * @param name 
 * @param color 
 * @param default 
 * @param description 
 */
@Serializable
data class IssueSearchResultItemLabelsModel(
    @SerialName(value = "id")
    val id: kotlin.Long? = null,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String? = null,
    @SerialName(value = "url")
    val url: kotlin.String? = null,
    @SerialName(value = "name")
    val name: kotlin.String? = null,
    @SerialName(value = "color")
    val color: kotlin.String? = null,
    @SerialName(value = "default")
    val default: kotlin.Boolean? = null,
    @SerialName(value = "description")
    val description: kotlin.String? = null
) {

}

