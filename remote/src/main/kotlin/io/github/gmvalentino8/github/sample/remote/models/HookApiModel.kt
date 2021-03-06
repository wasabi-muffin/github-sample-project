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

package io.github.gmvalentino8.github.sample.remote.models

import io.github.gmvalentino8.github.sample.remote.models.HookConfigApiModel
import io.github.gmvalentino8.github.sample.remote.models.HookMinusResponseApiModel

import kotlinx.serialization.*

/**
 * Webhooks for repositories.
 * @param type 
 * @param id Unique identifier of the webhook.
 * @param name The name of a valid service, use 'web' for a webhook.
 * @param active Determines whether the hook is actually triggered on pushes.
 * @param events Determines what events the hook is triggered for. Default: ['push'].
 * @param config 
 * @param updatedAt 
 * @param createdAt 
 * @param url 
 * @param testUrl 
 * @param pingUrl 
 * @param lastResponse 
 * @param deliveriesUrl 
 */
@Serializable
data class HookApiModel(
    @SerialName(value = "type")
    val type: kotlin.String,
    /* Unique identifier of the webhook. */
    @SerialName(value = "id")
    val id: kotlin.Int,
    /* The name of a valid service, use 'web' for a webhook. */
    @SerialName(value = "name")
    val name: kotlin.String,
    /* Determines whether the hook is actually triggered on pushes. */
    @SerialName(value = "active")
    val active: kotlin.Boolean,
    /* Determines what events the hook is triggered for. Default: ['push']. */
    @SerialName(value = "events")
    val events: kotlin.collections.List<kotlin.String>,
    @SerialName(value = "config")
    val config: HookConfigApiModel,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "test_url")
    val testUrl: kotlin.String,
    @SerialName(value = "ping_url")
    val pingUrl: kotlin.String,
    @SerialName(value = "last_response")
    val lastResponse: HookMinusResponseApiModel,
    @SerialName(value = "deliveries_url")
    val deliveriesUrl: kotlin.String? = null
) {

}

