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
 * @param name The name of the new repository.
 * @param owner The organization or person who will own the new repository. To create a new repository in an organization, the authenticated user must be a member of the specified organization.
 * @param description A short description of the new repository.
 * @param includeAllBranches Set to `true` to include the directory structure and files from all branches in the template repository, and not just the default branch. Default: `false`.
 * @param `private` Either `true` to create a new private repository or `false` to create a new public one.
 */
@Serializable
data class InlineObject140Model(
    /* The name of the new repository. */
    @SerialName(value = "name")
    val name: kotlin.String,
    /* The organization or person who will own the new repository. To create a new repository in an organization, the authenticated user must be a member of the specified organization. */
    @SerialName(value = "owner")
    val owner: kotlin.String? = null,
    /* A short description of the new repository. */
    @SerialName(value = "description")
    val description: kotlin.String? = null,
    /* Set to `true` to include the directory structure and files from all branches in the template repository, and not just the default branch. Default: `false`. */
    @SerialName(value = "include_all_branches")
    val includeAllBranches: kotlin.Boolean? = false,
    /* Either `true` to create a new private repository or `false` to create a new public one. */
    @SerialName(value = "private")
    val `private`: kotlin.Boolean? = false
) {

}

