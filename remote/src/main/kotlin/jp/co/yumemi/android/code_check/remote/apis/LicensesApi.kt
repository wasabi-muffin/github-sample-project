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

package jp.co.yumemi.android.code_check.remote.apis

import io.ktor.client.request.request
import jp.co.yumemi.android.code_check.data.models.*
import jp.co.yumemi.android.code_check.remote.core.HttpClientProvider
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

interface LicensesApi {
    /**
    * Get a license
    *
    * 
    *
    * @return LicenseModel
    */
    suspend fun licensesGet(accessToken: String? = null, license: kotlin.String): LicenseModel

    /**
    * Get all commonly used licenses
    *
    * 
    *
    * @return kotlin.collections.List<LicenseMinusSimpleModel>
    */
    suspend fun licensesGetAllCommonlyUsed(accessToken: String? = null, featured: kotlin.Boolean? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<LicenseMinusSimpleModel>

    /**
    * Get the license for a repository
    *
    * This method returns the contents of the repository&#39;s license file, if one is detected.  Similar to [Get repository content](https://docs.github.com/rest/reference/repos#get-repository-content), this method also supports [custom media types](https://docs.github.com/rest/overview/media-types) for retrieving the raw license content or rendered license HTML.
    *
    * @return LicenseMinusContentModel
    */
    suspend fun licensesGetForRepo(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String): LicenseMinusContentModel

}

class HttpClientLicensesApi(private val httpClientProvider: HttpClientProvider) : LicensesApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun licensesGet(accessToken: String?, license: kotlin.String): LicenseModel {
        val path = "/licenses/{license}".replace("{"+"license"+"}", "$license")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun licensesGetAllCommonlyUsed(accessToken: String?, featured: kotlin.Boolean?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<LicenseMinusSimpleModel> {
        val path = "/licenses"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("featured", featured)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun licensesGetForRepo(accessToken: String?, owner: kotlin.String, repo: kotlin.String): LicenseMinusContentModel {
        val path = "/repos/{owner}/{repo}/license".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

}
