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
 * @param id 
 * @param name 
 * @param visibility 
 * @param default 
 * @param runnersUrl 
 * @param inherited 
 * @param allowsPublicRepositories 
 * @param selectedRepositoriesUrl Link to the selected repositories resource for this runner group. Not present unless visibility was set to `selected`
 * @param inheritedAllowsPublicRepositories 
 */
@Serializable
data class RunnerMinusGroupsMinusOrgModel(
    @Contextual @SerialName(value = "id")
    val id: kotlin.Double,
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "visibility")
    val visibility: kotlin.String,
    @SerialName(value = "default")
    val default: kotlin.Boolean,
    @SerialName(value = "runners_url")
    val runnersUrl: kotlin.String,
    @SerialName(value = "inherited")
    val inherited: kotlin.Boolean,
    @SerialName(value = "allows_public_repositories")
    val allowsPublicRepositories: kotlin.Boolean,
    /* Link to the selected repositories resource for this runner group. Not present unless visibility was set to `selected` */
    @SerialName(value = "selected_repositories_url")
    val selectedRepositoriesUrl: kotlin.String? = null,
    @SerialName(value = "inherited_allows_public_repositories")
    val inheritedAllowsPublicRepositories: kotlin.Boolean? = null
) {

}

