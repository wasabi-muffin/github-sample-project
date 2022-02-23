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
 * @param url 
 * @param insecureSsl 
 * @param contentType 
 * @param secret 
 */
@Serializable
data class OrgHookConfigModel(
    @SerialName(value = "url")
    val url: kotlin.String? = null,
    @SerialName(value = "insecure_ssl")
    val insecureSsl: kotlin.String? = null,
    @SerialName(value = "content_type")
    val contentType: kotlin.String? = null,
    @SerialName(value = "secret")
    val secret: kotlin.String? = null
) {

}

