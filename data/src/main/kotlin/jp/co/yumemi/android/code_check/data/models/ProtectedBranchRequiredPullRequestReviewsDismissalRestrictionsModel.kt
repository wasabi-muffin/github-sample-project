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

import jp.co.yumemi.android.code_check.data.models.SimpleMinusUserModel
import jp.co.yumemi.android.code_check.data.models.TeamModel

import kotlinx.serialization.*

/**
 * 
 * @param url 
 * @param usersUrl 
 * @param teamsUrl 
 * @param users 
 * @param teams 
 */
@Serializable
data class ProtectedBranchRequiredPullRequestReviewsDismissalRestrictionsModel(
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "users_url")
    val usersUrl: kotlin.String,
    @SerialName(value = "teams_url")
    val teamsUrl: kotlin.String,
    @SerialName(value = "users")
    val users: kotlin.collections.List<SimpleMinusUserModel>,
    @SerialName(value = "teams")
    val teams: kotlin.collections.List<TeamModel>
) {

}

