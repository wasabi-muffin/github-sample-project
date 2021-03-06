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

import io.github.gmvalentino8.github.sample.remote.models.ScimV2EnterprisesEnterpriseGroupsScimGroupIdOperationsApiModel

import kotlinx.serialization.*

/**
 * 
 * @param schemas The SCIM schema URIs.
 * @param operations Array of [SCIM operations](https://tools.ietf.org/html/rfc7644#section-3.5.2).
 */
@Serializable
data class InlineObject144ApiModel(
    /* The SCIM schema URIs. */
    @SerialName(value = "schemas")
    val schemas: kotlin.collections.List<kotlin.String>,
    /* Array of [SCIM operations](https://tools.ietf.org/html/rfc7644#section-3.5.2). */
    @SerialName(value = "Operations")
    val operations: kotlin.collections.List<ScimV2EnterprisesEnterpriseGroupsScimGroupIdOperationsApiModel>
) {

}

