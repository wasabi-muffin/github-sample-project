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

import io.github.gmvalentino8.github.sample.remote.models.SecretMinusScanningMinusAlertMinusResolutionApiModel
import io.github.gmvalentino8.github.sample.remote.models.SecretMinusScanningMinusAlertMinusStateApiModel

import kotlinx.serialization.*

/**
 * 
 * @param state 
 * @param resolution 
 */
@Serializable
data class InlineObject135ApiModel(
    @Contextual @SerialName(value = "state")
    val state: SecretMinusScanningMinusAlertMinusStateApiModel,
    @Contextual @SerialName(value = "resolution")
    val resolution: SecretMinusScanningMinusAlertMinusResolutionApiModel? = null
) {

}

