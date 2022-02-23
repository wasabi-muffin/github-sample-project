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
 * @param clientId 
 * @param name 
 * @param url 
 */
@Serializable
data class ApplicationGrantAppModel(
    @SerialName(value = "client_id")
    val clientId: kotlin.String,
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String
) {

}

