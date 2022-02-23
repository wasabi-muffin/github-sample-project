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
 * @param title 
 * @param summary 
 * @param text 
 * @param annotationsCount 
 * @param annotationsUrl 
 */
@Serializable
data class CheckRunOutputModel(
    @SerialName(value = "title")
    val title: kotlin.String?,
    @SerialName(value = "summary")
    val summary: kotlin.String?,
    @SerialName(value = "text")
    val text: kotlin.String?,
    @SerialName(value = "annotations_count")
    val annotationsCount: kotlin.Int,
    @SerialName(value = "annotations_url")
    val annotationsUrl: kotlin.String
) {

}

