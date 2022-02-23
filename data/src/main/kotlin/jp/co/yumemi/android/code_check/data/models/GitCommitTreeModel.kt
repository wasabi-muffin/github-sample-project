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
 * @param sha SHA for the commit
 * @param url 
 */
@Serializable
data class GitCommitTreeModel(
    /* SHA for the commit */
    @SerialName(value = "sha")
    val sha: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String
) {

}

