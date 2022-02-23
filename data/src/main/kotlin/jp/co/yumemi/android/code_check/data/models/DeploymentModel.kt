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

import jp.co.yumemi.android.code_check.data.models.NullableMinusIntegrationModel
import jp.co.yumemi.android.code_check.data.models.NullableMinusSimpleMinusUserModel

import kotlinx.serialization.*

/**
 * A request for a specific ref(branch,sha,tag) to be deployed
 * @param url 
 * @param id Unique identifier of the deployment
 * @param nodeId 
 * @param sha 
 * @param ref The ref to deploy. This can be a branch, tag, or sha.
 * @param task Parameter to specify a task to execute
 * @param payload 
 * @param environment Name for the target deployment environment.
 * @param description 
 * @param creator 
 * @param createdAt 
 * @param updatedAt 
 * @param statusesUrl 
 * @param repositoryUrl 
 * @param originalEnvironment 
 * @param transientEnvironment Specifies if the given environment is will no longer exist at some point in the future. Default: false.
 * @param productionEnvironment Specifies if the given environment is one that end-users directly interact with. Default: false.
 * @param performedViaGithubApp 
 */
@Serializable
data class DeploymentModel(
    @SerialName(value = "url")
    val url: kotlin.String,
    /* Unique identifier of the deployment */
    @SerialName(value = "id")
    val id: kotlin.Int,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    @SerialName(value = "sha")
    val sha: kotlin.String,
    /* The ref to deploy. This can be a branch, tag, or sha. */
    @SerialName(value = "ref")
    val ref: kotlin.String,
    /* Parameter to specify a task to execute */
    @SerialName(value = "task")
    val task: kotlin.String,
    @SerialName(value = "payload")
    val payload: kotlin.String,
    /* Name for the target deployment environment. */
    @SerialName(value = "environment")
    val environment: kotlin.String,
    @SerialName(value = "description")
    val description: kotlin.String?,
    @SerialName(value = "creator")
    val creator: NullableMinusSimpleMinusUserModel?,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "statuses_url")
    val statusesUrl: kotlin.String,
    @SerialName(value = "repository_url")
    val repositoryUrl: kotlin.String,
    @SerialName(value = "original_environment")
    val originalEnvironment: kotlin.String? = null,
    /* Specifies if the given environment is will no longer exist at some point in the future. Default: false. */
    @SerialName(value = "transient_environment")
    val transientEnvironment: kotlin.Boolean? = null,
    /* Specifies if the given environment is one that end-users directly interact with. Default: false. */
    @SerialName(value = "production_environment")
    val productionEnvironment: kotlin.Boolean? = null,
    @SerialName(value = "performed_via_github_app")
    val performedViaGithubApp: NullableMinusIntegrationModel? = null
) {

}

