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

import io.github.gmvalentino8.github.sample.remote.models.DeploymentMinusReviewerMinusTypeApiModel

import kotlinx.serialization.*

/**
 * 
 * @param type 
 * @param id The id of the user or team who can review the deployment
 */
@Serializable
data class ReposRepoNameEnvironmentsEnvironmentNameReviewersApiModel(
    @Contextual @SerialName(value = "type")
    val type: DeploymentMinusReviewerMinusTypeApiModel? = null,
    /* The id of the user or team who can review the deployment */
    @SerialName(value = "id")
    val id: kotlin.Int? = null
) {

}
