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

import jp.co.yumemi.android.code_check.data.models.PackageVersionMetadataModel

import kotlinx.serialization.*

/**
 * A version of a software package
 * @param id Unique identifier of the package version.
 * @param name The name of the package version.
 * @param url 
 * @param packageHtmlUrl 
 * @param createdAt 
 * @param updatedAt 
 * @param htmlUrl 
 * @param license 
 * @param description 
 * @param deletedAt 
 * @param metadata 
 */
@Serializable
data class PackageMinusVersionModel(
    /* Unique identifier of the package version. */
    @SerialName(value = "id")
    val id: kotlin.Int,
    /* The name of the package version. */
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "package_html_url")
    val packageHtmlUrl: kotlin.String,
    @SerialName(value = "created_at")
    val createdAt: kotlin.String,
    @SerialName(value = "updated_at")
    val updatedAt: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String? = null,
    @SerialName(value = "license")
    val license: kotlin.String? = null,
    @SerialName(value = "description")
    val description: kotlin.String? = null,
    @SerialName(value = "deleted_at")
    val deletedAt: kotlin.String? = null,
    @SerialName(value = "metadata")
    val metadata: PackageVersionMetadataModel? = null
) {

}

