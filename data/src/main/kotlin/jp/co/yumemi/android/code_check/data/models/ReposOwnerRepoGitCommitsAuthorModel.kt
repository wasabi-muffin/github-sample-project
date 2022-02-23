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
 * Information about the author of the commit. By default, the `author` will be the authenticated user and the current date. See the `author` and `committer` object below for details.
 * @param name The name of the author (or committer) of the commit
 * @param email The email of the author (or committer) of the commit
 * @param date Indicates when this commit was authored (or committed). This is a timestamp in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format: `YYYY-MM-DDTHH:MM:SSZ`.
 */
@Serializable
data class ReposOwnerRepoGitCommitsAuthorModel(
    /* The name of the author (or committer) of the commit */
    @SerialName(value = "name")
    val name: kotlin.String,
    /* The email of the author (or committer) of the commit */
    @SerialName(value = "email")
    val email: kotlin.String,
    /* Indicates when this commit was authored (or committed). This is a timestamp in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format: `YYYY-MM-DDTHH:MM:SSZ`. */
    @SerialName(value = "date")
    val date: kotlin.String? = null
) {

}
