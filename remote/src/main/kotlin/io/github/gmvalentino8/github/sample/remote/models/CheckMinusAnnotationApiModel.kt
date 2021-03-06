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
 * Check Annotation
 * @param path 
 * @param startLine 
 * @param endLine 
 * @param startColumn 
 * @param endColumn 
 * @param annotationLevel 
 * @param title 
 * @param message 
 * @param rawDetails 
 * @param blobHref 
 */
@Serializable
data class CheckMinusAnnotationApiModel(
    @SerialName(value = "path")
    val path: kotlin.String,
    @SerialName(value = "start_line")
    val startLine: kotlin.Int,
    @SerialName(value = "end_line")
    val endLine: kotlin.Int,
    @SerialName(value = "start_column")
    val startColumn: kotlin.Int?,
    @SerialName(value = "end_column")
    val endColumn: kotlin.Int?,
    @SerialName(value = "annotation_level")
    val annotationLevel: kotlin.String?,
    @SerialName(value = "title")
    val title: kotlin.String?,
    @SerialName(value = "message")
    val message: kotlin.String?,
    @SerialName(value = "raw_details")
    val rawDetails: kotlin.String?,
    @SerialName(value = "blob_href")
    val blobHref: kotlin.String
) {

}

