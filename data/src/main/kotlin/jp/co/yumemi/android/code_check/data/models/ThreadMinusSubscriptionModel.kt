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
 * Thread Subscription
 * @param subscribed 
 * @param ignored 
 * @param reason 
 * @param createdAt 
 * @param url 
 * @param threadUrl 
 * @param repositoryUrl 
 */
@Serializable
data class ThreadMinusSubscriptionModel(
    @SerialName(value = "subscribed")
    val subscribed: kotlin.Boolean,
    @SerialName(value = "ignored")
    val ignored: kotlin.Boolean,
    @SerialName(value = "reason")
    val reason: kotlin.String?,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String?,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "thread_url")
    val threadUrl: kotlin.String? = null,
    @SerialName(value = "repository_url")
    val repositoryUrl: kotlin.String? = null
) {

}

