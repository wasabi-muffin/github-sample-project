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
 * @param tagName The tag name for the release. This can be an existing tag or a new one.
 * @param targetCommitish Specifies the commitish value that will be the target for the release's tag. Required if the supplied tag_name does not reference an existing tag. Ignored if the tag_name already exists.
 * @param previousTagName The name of the previous tag to use as the starting point for the release notes. Use to manually specify the range for the set of changes considered as part this release.
 * @param configurationFilePath Specifies a path to a file in the repository containing configuration settings used for generating the release notes. If unspecified, the configuration file located in the repository at '.github/release.yml' or '.github/release.yaml' will be used. If that is not present, the default configuration will be used.
 */
@Serializable
data class InlineObject132Model(
    /* The tag name for the release. This can be an existing tag or a new one. */
    @SerialName(value = "tag_name")
    val tagName: kotlin.String,
    /* Specifies the commitish value that will be the target for the release's tag. Required if the supplied tag_name does not reference an existing tag. Ignored if the tag_name already exists. */
    @SerialName(value = "target_commitish")
    val targetCommitish: kotlin.String? = null,
    /* The name of the previous tag to use as the starting point for the release notes. Use to manually specify the range for the set of changes considered as part this release. */
    @SerialName(value = "previous_tag_name")
    val previousTagName: kotlin.String? = null,
    /* Specifies a path to a file in the repository containing configuration settings used for generating the release notes. If unspecified, the configuration file located in the repository at '.github/release.yml' or '.github/release.yaml' will be used. If that is not present, the default configuration will be used. */
    @SerialName(value = "configuration_file_path")
    val configurationFilePath: kotlin.String? = null
) {

}

