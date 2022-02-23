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

import jp.co.yumemi.android.code_check.data.models.ContentTreeLinksModel

import kotlinx.serialization.*

/**
 * Content File
 * @param type 
 * @param encoding 
 * @param propertySize 
 * @param name 
 * @param path 
 * @param content 
 * @param sha 
 * @param url 
 * @param gitUrl 
 * @param htmlUrl 
 * @param downloadUrl 
 * @param links 
 * @param target 
 * @param submoduleGitUrl 
 */
@Serializable
data class ContentMinusFileModel(
    @SerialName(value = "type")
    val type: kotlin.String,
    @SerialName(value = "encoding")
    val encoding: kotlin.String,
    @SerialName(value = "size")
    val propertySize: kotlin.Int,
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "path")
    val path: kotlin.String,
    @SerialName(value = "content")
    val content: kotlin.String,
    @SerialName(value = "sha")
    val sha: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "git_url")
    val gitUrl: kotlin.String?,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String?,
    @SerialName(value = "download_url")
    val downloadUrl: kotlin.String?,
    @SerialName(value = "_links")
    val links: ContentTreeLinksModel,
    @SerialName(value = "target")
    val target: kotlin.String? = null,
    @SerialName(value = "submodule_git_url")
    val submoduleGitUrl: kotlin.String? = null
) {

}
