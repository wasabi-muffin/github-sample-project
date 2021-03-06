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

import io.github.gmvalentino8.github.sample.remote.models.RateLimitOverviewResourcesApiModel
import io.github.gmvalentino8.github.sample.remote.models.RateMinusLimitApiModel

import kotlinx.serialization.*

/**
 * Rate Limit Overview
 * @param resources 
 * @param rate 
 */
@Serializable
data class RateMinusLimitMinusOverviewApiModel(
    @SerialName(value = "resources")
    val resources: RateLimitOverviewResourcesApiModel,
    @SerialName(value = "rate")
    val rate: RateMinusLimitApiModel
) {

}

