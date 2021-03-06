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

import io.github.gmvalentino8.github.sample.remote.models.AllowedMinusActionsApiModel
import io.github.gmvalentino8.github.sample.remote.models.EnabledMinusRepositoriesApiModel

import kotlinx.serialization.*

/**
 * 
 * @param enabledRepositories 
 * @param allowedActions 
 */
@Serializable
data class InlineObject18ApiModel(
    @Contextual @SerialName(value = "enabled_repositories")
    val enabledRepositories: EnabledMinusRepositoriesApiModel,
    @Contextual @SerialName(value = "allowed_actions")
    val allowedActions: AllowedMinusActionsApiModel? = null
) {

}

