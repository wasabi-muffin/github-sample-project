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


import kotlinx.serialization.*

/**
 * Identifying information for the git-user
 * @param date Timestamp of the commit
 * @param email Git email address of the user
 * @param name Name of the git user
 */
@Serializable
data class GitCommitAuthorApiModel(
    /* Timestamp of the commit */
    @SerialName(value = "date")
    val date: kotlin.String,
    /* Git email address of the user */
    @SerialName(value = "email")
    val email: kotlin.String,
    /* Name of the git user */
    @SerialName(value = "name")
    val name: kotlin.String
) {

}

