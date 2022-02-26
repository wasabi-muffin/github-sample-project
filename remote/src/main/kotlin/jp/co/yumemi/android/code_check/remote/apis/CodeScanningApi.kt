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
import jp.co.yumemi.android.code_check.remote.models.*
import jp.co.yumemi.android.code_check.remote.core.HttpClientProvider
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

interface CodeScanningApi {
    /**
    * Delete a code scanning analysis from a repository
    *
    * Deletes a specified code scanning analysis from a repository. For private repositories, you must use an access token with the &#x60;repo&#x60; scope. For public repositories, you must use an access token with &#x60;public_repo&#x60; scope. GitHub Apps must have the &#x60;security_events&#x60; write permission to use this endpoint.  You can delete one analysis at a time. To delete a series of analyses, start with the most recent analysis and work backwards. Conceptually, the process is similar to the undo function in a text editor.  When you list the analyses for a repository, one or more will be identified as deletable in the response:  &#x60;&#x60;&#x60; \&quot;deletable\&quot;: true &#x60;&#x60;&#x60;  An analysis is deletable when it&#39;s the most recent in a set of analyses. Typically, a repository will have multiple sets of analyses for each enabled code scanning tool, where a set is determined by a unique combination of analysis values:  * &#x60;ref&#x60; * &#x60;tool&#x60; * &#x60;analysis_key&#x60; * &#x60;environment&#x60;  If you attempt to delete an analysis that is not the most recent in a set, you&#39;ll get a 400 response with the message:  &#x60;&#x60;&#x60; Analysis specified is not deletable. &#x60;&#x60;&#x60;  The response from a successful &#x60;DELETE&#x60; operation provides you with two alternative URLs for deleting the next analysis in the set: &#x60;next_analysis_url&#x60; and &#x60;confirm_delete_url&#x60;. Use the &#x60;next_analysis_url&#x60; URL if you want to avoid accidentally deleting the final analysis in a set. This is a useful option if you want to preserve at least one analysis for the specified tool in your repository. Use the &#x60;confirm_delete_url&#x60; URL if you are content to remove all analyses for a tool. When you delete the last analysis in a set, the value of &#x60;next_analysis_url&#x60; and &#x60;confirm_delete_url&#x60; in the 200 response is &#x60;null&#x60;.  As an example of the deletion process, let&#39;s imagine that you added a workflow that configured a particular code scanning tool to analyze the code in a repository. This tool has added 15 analyses: 10 on the default branch, and another 5 on a topic branch. You therefore have two separate sets of analyses for this tool. You&#39;ve now decided that you want to remove all of the analyses for the tool. To do this you must make 15 separate deletion requests. To start, you must find an analysis that&#39;s identified as deletable. Each set of analyses always has one that&#39;s identified as deletable. Having found the deletable analysis for one of the two sets, delete this analysis and then continue deleting the next analysis in the set until they&#39;re all deleted. Then repeat the process for the second set. The procedure therefore consists of a nested loop:  **Outer loop**: * List the analyses for the repository, filtered by tool. * Parse this list to find a deletable analysis. If found:    **Inner loop**:   * Delete the identified analysis.   * Parse the response for the value of &#x60;confirm_delete_url&#x60; and, if found, use this in the next iteration.  The above process assumes that you want to remove all trace of the tool&#39;s analyses from the GitHub user interface, for the specified repository, and it therefore uses the &#x60;confirm_delete_url&#x60; value. Alternatively, you could use the &#x60;next_analysis_url&#x60; value, which would leave the last analysis in each set undeleted to avoid removing a tool&#39;s analysis entirely.
    *
    * @return CodeMinusScanningMinusAnalysisMinusDeletionApiModel
    */
    suspend fun codeScanningDeleteAnalysis(accessToken: String? = null, repoName: kotlin.String, analysisId: kotlin.Int, confirmDelete: kotlin.String? = null): CodeMinusScanningMinusAnalysisMinusDeletionApiModel

    /**
    * Get a code scanning alert
    *
    * Gets a single code scanning alert. You must use an access token with the &#x60;security_events&#x60; scope to use this endpoint with private repos, the &#x60;public_repo&#x60; scope also grants permission to read security events on public repos only. GitHub Apps must have the &#x60;security_events&#x60; read permission to use this endpoint.  **Deprecation notice**: The instances field is deprecated and will, in future, not be included in the response for this endpoint. The example response reflects this change. The same information can now be retrieved via a GET request to the URL specified by &#x60;instances_url&#x60;.
    *
    * @return CodeMinusScanningMinusAlertApiModel
    */
    suspend fun codeScanningGetAlert(accessToken: String? = null, repoName: kotlin.String, alertNumber: kotlin.Int): CodeMinusScanningMinusAlertApiModel

    /**
    * Get a code scanning analysis for a repository
    *
    * Gets a specified code scanning analysis for a repository. You must use an access token with the &#x60;security_events&#x60; scope to use this endpoint with private repos, the &#x60;public_repo&#x60; scope also grants permission to read security events on public repos only. GitHub Apps must have the &#x60;security_events&#x60; read permission to use this endpoint.  The default JSON response contains fields that describe the analysis. This includes the Git reference and commit SHA to which the analysis relates, the datetime of the analysis, the name of the code scanning tool, and the number of alerts.  The &#x60;rules_count&#x60; field in the default response give the number of rules that were run in the analysis. For very old analyses this data is not available, and &#x60;0&#x60; is returned in this field.  If you use the Accept header &#x60;application/sarif+json&#x60;, the response contains the analysis data that was uploaded. This is formatted as [SARIF version 2.1.0](https://docs.oasis-open.org/sarif/sarif/v2.1.0/cs01/sarif-v2.1.0-cs01.html).
    *
    * @return kotlin.String
    */
    suspend fun codeScanningGetAnalysis(accessToken: String? = null, repoName: kotlin.String, analysisId: kotlin.Int): kotlin.String

    /**
    * Get information about a SARIF upload
    *
    * Gets information about a SARIF upload, including the status and the URL of the analysis that was uploaded so that you can retrieve details of the analysis. For more information, see \&quot;[Get a code scanning analysis for a repository](/rest/reference/code-scanning#get-a-code-scanning-analysis-for-a-repository).\&quot; You must use an access token with the &#x60;security_events&#x60; scope to use this endpoint with private repos, the &#x60;public_repo&#x60; scope also grants permission to read security events on public repos only. GitHub Apps must have the &#x60;security_events&#x60; read permission to use this endpoint.
    *
    * @return CodeMinusScanningMinusSarifsMinusStatusApiModel
    */
    suspend fun codeScanningGetSarif(accessToken: String? = null, repoName: kotlin.String, sarifId: kotlin.String): CodeMinusScanningMinusSarifsMinusStatusApiModel

    /**
    * List instances of a code scanning alert
    *
    * Lists all instances of the specified code scanning alert. You must use an access token with the &#x60;security_events&#x60; scope to use this endpoint with private repos, the &#x60;public_repo&#x60; scope also grants permission to read security events on public repos only. GitHub Apps must have the &#x60;security_events&#x60; read permission to use this endpoint.
    *
    * @return kotlin.collections.List<CodeMinusScanningMinusAlertMinusInstanceApiModel>
    */
    suspend fun codeScanningListAlertInstances(accessToken: String? = null, repoName: kotlin.String, alertNumber: kotlin.Int, page: kotlin.Int? = null, perPage: kotlin.Int? = null, ref: kotlin.String? = null): kotlin.collections.List<CodeMinusScanningMinusAlertMinusInstanceApiModel>

    /**
    * List code scanning alerts for an organization
    *
    * Lists all code scanning alerts for the default branch (usually &#x60;main&#x60; or &#x60;master&#x60;) for all eligible repositories in an organization. To use this endpoint, you must be an administrator or security manager for the organization, and you must use an access token with the &#x60;repo&#x60; scope or &#x60;security_events&#x60; scope.  GitHub Apps must have the &#x60;security_events&#x60; read permission to use this endpoint.
    *
    * @return kotlin.collections.List<CodeMinusScanningMinusOrganizationMinusAlertMinusItemsApiModel>
    */
    suspend fun codeScanningListAlertsForOrg(accessToken: String? = null, org: kotlin.String, before: kotlin.String? = null, after: kotlin.String? = null, page: kotlin.Int? = null, perPage: kotlin.Int? = null, direction: kotlin.String? = null, state: CodeMinusScanningMinusAlertMinusStateApiModel? = null, sort: kotlin.String? = null): kotlin.collections.List<CodeMinusScanningMinusOrganizationMinusAlertMinusItemsApiModel>

    /**
    * List code scanning alerts for a repository
    *
    * Lists all open code scanning alerts for the default branch (usually &#x60;main&#x60; or &#x60;master&#x60;). You must use an access token with the &#x60;security_events&#x60; scope to use this endpoint with private repos, the &#x60;public_repo&#x60; scope also grants permission to read security events on public repos only. GitHub Apps must have the &#x60;security_events&#x60; read permission to use this endpoint.  The response includes a &#x60;most_recent_instance&#x60; object. This provides details of the most recent instance of this alert for the default branch or for the specified Git reference (if you used &#x60;ref&#x60; in the request).
    *
    * @return kotlin.collections.List<CodeMinusScanningMinusAlertMinusItemsApiModel>
    */
    suspend fun codeScanningListAlertsForRepo(accessToken: String? = null, repoName: kotlin.String, toolName: kotlin.String? = null, toolGuid: kotlin.String? = null, page: kotlin.Int? = null, perPage: kotlin.Int? = null, ref: kotlin.String? = null, direction: kotlin.String? = null, sort: kotlin.String? = null, state: CodeMinusScanningMinusAlertMinusStateApiModel? = null): kotlin.collections.List<CodeMinusScanningMinusAlertMinusItemsApiModel>

    /**
    * List code scanning analyses for a repository
    *
    * Lists the details of all code scanning analyses for a repository, starting with the most recent. The response is paginated and you can use the &#x60;page&#x60; and &#x60;per_page&#x60; parameters to list the analyses you&#39;re interested in. By default 30 analyses are listed per page.  The &#x60;rules_count&#x60; field in the response give the number of rules that were run in the analysis. For very old analyses this data is not available, and &#x60;0&#x60; is returned in this field.  You must use an access token with the &#x60;security_events&#x60; scope to use this endpoint with private repos, the &#x60;public_repo&#x60; scope also grants permission to read security events on public repos only. GitHub Apps must have the &#x60;security_events&#x60; read permission to use this endpoint.  **Deprecation notice**: The &#x60;tool_name&#x60; field is deprecated and will, in future, not be included in the response for this endpoint. The example response reflects this change. The tool name can now be found inside the &#x60;tool&#x60; field.
    *
    * @return kotlin.collections.List<CodeMinusScanningMinusAnalysisApiModel>
    */
    suspend fun codeScanningListRecentAnalyses(accessToken: String? = null, repoName: kotlin.String, toolName: kotlin.String? = null, toolGuid: kotlin.String? = null, page: kotlin.Int? = null, perPage: kotlin.Int? = null, ref: kotlin.String? = null, sarifId: kotlin.String? = null): kotlin.collections.List<CodeMinusScanningMinusAnalysisApiModel>

    /**
    * Update a code scanning alert
    *
    * Updates the status of a single code scanning alert. You must use an access token with the &#x60;security_events&#x60; scope to use this endpoint with private repositories. You can also use tokens with the &#x60;public_repo&#x60; scope for public repositories only. GitHub Apps must have the &#x60;security_events&#x60; write permission to use this endpoint.
    *
    * @param request 
    * @return CodeMinusScanningMinusAlertApiModel
    */
    suspend fun codeScanningUpdateAlert(accessToken: String? = null, repoName: kotlin.String, alertNumber: kotlin.Int, request: InlineObject71ApiModel): CodeMinusScanningMinusAlertApiModel

    /**
    * Upload an analysis as SARIF data
    *
    * Uploads SARIF data containing the results of a code scanning analysis to make the results available in a repository. You must use an access token with the &#x60;security_events&#x60; scope to use this endpoint for private repositories. You can also use tokens with the &#x60;public_repo&#x60; scope for public repositories only. GitHub Apps must have the &#x60;security_events&#x60; write permission to use this endpoint.  There are two places where you can upload code scanning results.  - If you upload to a pull request, for example &#x60;--ref refs/pull/42/merge&#x60; or &#x60;--ref refs/pull/42/head&#x60;, then the results appear as alerts in a pull request check. For more information, see \&quot;[Triaging code scanning alerts in pull requests](/code-security/secure-coding/triaging-code-scanning-alerts-in-pull-requests).\&quot;  - If you upload to a branch, for example &#x60;--ref refs/heads/my-branch&#x60;, then the results appear in the **Security** tab for your repository. For more information, see \&quot;[Managing code scanning alerts for your repository](/code-security/secure-coding/managing-code-scanning-alerts-for-your-repository#viewing-the-alerts-for-a-repository).\&quot;  You must compress the SARIF-formatted analysis data that you want to upload, using &#x60;gzip&#x60;, and then encode it as a Base64 format string. For example:  &#x60;&#x60;&#x60; gzip -c analysis-data.sarif | base64 -w0 &#x60;&#x60;&#x60;  SARIF upload supports a maximum of 5000 results per analysis run. Any results over this limit are ignored and any SARIF uploads with more than 25,000 results are rejected. Typically, but not necessarily, a SARIF file contains a single run of a single tool. If a code scanning tool generates too many results, you should update the analysis configuration to run only the most important rules or queries.  The &#x60;202 Accepted&#x60;, response includes an &#x60;id&#x60; value. You can use this ID to check the status of the upload by using this for the &#x60;/sarifs/{sarif_id}&#x60; endpoint. For more information, see \&quot;[Get information about a SARIF upload](/rest/reference/code-scanning#get-information-about-a-sarif-upload).\&quot;
    *
    * @param request 
    * @return CodeMinusScanningMinusSarifsMinusReceiptApiModel
    */
    suspend fun codeScanningUploadSarif(accessToken: String? = null, repoName: kotlin.String, request: InlineObject72ApiModel): CodeMinusScanningMinusSarifsMinusReceiptApiModel

}

class HttpClientCodeScanningApi(private val httpClientProvider: HttpClientProvider) : CodeScanningApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun codeScanningDeleteAnalysis(accessToken: String?, repoName: kotlin.String, analysisId: kotlin.Int, confirmDelete: kotlin.String?): CodeMinusScanningMinusAnalysisMinusDeletionApiModel {
        val path = "/repos/{repo_name}/code-scanning/analyses/{analysis_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"analysis_id"+"}", "$analysisId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
            parameter("confirmDelete", confirmDelete)
        }
    }

    override suspend fun codeScanningGetAlert(accessToken: String?, repoName: kotlin.String, alertNumber: kotlin.Int): CodeMinusScanningMinusAlertApiModel {
        val path = "/repos/{repo_name}/code-scanning/alerts/{alert_number}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"alert_number"+"}", "$alertNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun codeScanningGetAnalysis(accessToken: String?, repoName: kotlin.String, analysisId: kotlin.Int): kotlin.String {
        val path = "/repos/{repo_name}/code-scanning/analyses/{analysis_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"analysis_id"+"}", "$analysisId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun codeScanningGetSarif(accessToken: String?, repoName: kotlin.String, sarifId: kotlin.String): CodeMinusScanningMinusSarifsMinusStatusApiModel {
        val path = "/repos/{repo_name}/code-scanning/sarifs/{sarif_id}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"sarif_id"+"}", "$sarifId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun codeScanningListAlertInstances(accessToken: String?, repoName: kotlin.String, alertNumber: kotlin.Int, page: kotlin.Int?, perPage: kotlin.Int?, ref: kotlin.String?): kotlin.collections.List<CodeMinusScanningMinusAlertMinusInstanceApiModel> {
        val path = "/repos/{repo_name}/code-scanning/alerts/{alert_number}/instances".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"alert_number"+"}", "$alertNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("page", page)
            parameter("perPage", perPage)
            parameter("ref", ref)
        }
    }

    override suspend fun codeScanningListAlertsForOrg(accessToken: String?, org: kotlin.String, before: kotlin.String?, after: kotlin.String?, page: kotlin.Int?, perPage: kotlin.Int?, direction: kotlin.String?, state: CodeMinusScanningMinusAlertMinusStateApiModel?, sort: kotlin.String?): kotlin.collections.List<CodeMinusScanningMinusOrganizationMinusAlertMinusItemsApiModel> {
        val path = "/orgs/{org}/code-scanning/alerts".replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("before", before)
            parameter("after", after)
            parameter("page", page)
            parameter("perPage", perPage)
            parameter("direction", direction)
            parameter("state", state)
            parameter("sort", sort)
        }
    }

    override suspend fun codeScanningListAlertsForRepo(accessToken: String?, repoName: kotlin.String, toolName: kotlin.String?, toolGuid: kotlin.String?, page: kotlin.Int?, perPage: kotlin.Int?, ref: kotlin.String?, direction: kotlin.String?, sort: kotlin.String?, state: CodeMinusScanningMinusAlertMinusStateApiModel?): kotlin.collections.List<CodeMinusScanningMinusAlertMinusItemsApiModel> {
        val path = "/repos/{repo_name}/code-scanning/alerts".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("toolName", toolName)
            parameter("toolGuid", toolGuid)
            parameter("page", page)
            parameter("perPage", perPage)
            parameter("ref", ref)
            parameter("direction", direction)
            parameter("sort", sort)
            parameter("state", state)
        }
    }

    override suspend fun codeScanningListRecentAnalyses(accessToken: String?, repoName: kotlin.String, toolName: kotlin.String?, toolGuid: kotlin.String?, page: kotlin.Int?, perPage: kotlin.Int?, ref: kotlin.String?, sarifId: kotlin.String?): kotlin.collections.List<CodeMinusScanningMinusAnalysisApiModel> {
        val path = "/repos/{repo_name}/code-scanning/analyses".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("toolName", toolName)
            parameter("toolGuid", toolGuid)
            parameter("page", page)
            parameter("perPage", perPage)
            parameter("ref", ref)
            parameter("sarifId", sarifId)
        }
    }

    override suspend fun codeScanningUpdateAlert(accessToken: String?, repoName: kotlin.String, alertNumber: kotlin.Int, request: InlineObject71ApiModel): CodeMinusScanningMinusAlertApiModel {
        val path = "/repos/{repo_name}/code-scanning/alerts/{alert_number}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"alert_number"+"}", "$alertNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

    override suspend fun codeScanningUploadSarif(accessToken: String?, repoName: kotlin.String, request: InlineObject72ApiModel): CodeMinusScanningMinusSarifsMinusReceiptApiModel {
        val path = "/repos/{repo_name}/code-scanning/sarifs".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

}
