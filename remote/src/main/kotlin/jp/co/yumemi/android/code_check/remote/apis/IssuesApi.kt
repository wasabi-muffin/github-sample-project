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

interface IssuesApi {
    /**
    * Add assignees to an issue
    *
    * Adds up to 10 assignees to an issue. Users already assigned to an issue are not replaced.
    *
    * @param request  (optional)
    * @return IssueApiModel
    */
    suspend fun issuesAddAssignees(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject103ApiModel): IssueApiModel

    /**
    * Check if a user can be assigned
    *
    * Checks if a user has permission to be assigned to an issue in this repository.  If the &#x60;assignee&#x60; can be assigned to issues in the repository, a &#x60;204&#x60; header with no content is returned.  Otherwise a &#x60;404&#x60; status code is returned.
    *
    * @return void
    */
    suspend fun issuesCheckUserCanBeAssigned(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, assignee: kotlin.String)

    /**
    * Create an issue
    *
    * Any user with pull access to a repository can create an issue. If [issues are disabled in the repository](https://docs.github.com/articles/disabling-issues/), the API returns a &#x60;410 Gone&#x60; status.  This endpoint triggers [notifications](https://docs.github.com/github/managing-subscriptions-and-notifications-on-github/about-notifications). Creating content too quickly using this endpoint may result in secondary rate limiting. See \&quot;[Secondary rate limits](https://docs.github.com/rest/overview/resources-in-the-rest-api#secondary-rate-limits)\&quot; and \&quot;[Dealing with secondary rate limits](https://docs.github.com/rest/guides/best-practices-for-integrators#dealing-with-secondary-rate-limits)\&quot; for details.
    *
    * @param request 
    * @return IssueApiModel
    */
    suspend fun issuesCreate(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, request: InlineObject99ApiModel): IssueApiModel

    /**
    * Create an issue comment
    *
    * This endpoint triggers [notifications](https://docs.github.com/github/managing-subscriptions-and-notifications-on-github/about-notifications). Creating content too quickly using this endpoint may result in secondary rate limiting. See \&quot;[Secondary rate limits](https://docs.github.com/rest/overview/resources-in-the-rest-api#secondary-rate-limits)\&quot; and \&quot;[Dealing with secondary rate limits](https://docs.github.com/rest/guides/best-practices-for-integrators#dealing-with-secondary-rate-limits)\&quot; for details.
    *
    * @param request 
    * @return IssueMinusCommentApiModel
    */
    suspend fun issuesCreateComment(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject105ApiModel): IssueMinusCommentApiModel

    /**
    * Create a label
    *
    * 
    *
    * @param request 
    * @return LabelApiModel
    */
    suspend fun issuesCreateLabel(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, request: InlineObject109ApiModel): LabelApiModel

    /**
    * Create a milestone
    *
    * 
    *
    * @param request 
    * @return MilestoneApiModel
    */
    suspend fun issuesCreateMilestone(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, request: InlineObject113ApiModel): MilestoneApiModel

    /**
    * Delete an issue comment
    *
    * 
    *
    * @return void
    */
    suspend fun issuesDeleteComment(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, commentId: kotlin.Int)

    /**
    * Delete a label
    *
    * 
    *
    * @return void
    */
    suspend fun issuesDeleteLabel(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, name: kotlin.String)

    /**
    * Delete a milestone
    *
    * 
    *
    * @return void
    */
    suspend fun issuesDeleteMilestone(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, milestoneNumber: kotlin.Int)

    /**
    * Get an issue
    *
    * The API returns a [&#x60;301 Moved Permanently&#x60; status](https://docs.github.com/rest/overview/resources-in-the-rest-api#http-redirects-redirects) if the issue was [transferred](https://docs.github.com/articles/transferring-an-issue-to-another-repository/) to another repository. If the issue was transferred to or deleted from a repository where the authenticated user lacks read access, the API returns a &#x60;404 Not Found&#x60; status. If the issue was deleted from a repository where the authenticated user has read access, the API returns a &#x60;410 Gone&#x60; status. To receive webhook events for transferred and deleted issues, subscribe to the [&#x60;issues&#x60;](https://docs.github.com/webhooks/event-payloads/#issues) webhook.  **Note**: GitHub&#39;s REST API v3 considers every pull request an issue, but not every issue is a pull request. For this reason, \&quot;Issues\&quot; endpoints may return both issues and pull requests in the response. You can identify pull requests by the &#x60;pull_request&#x60; key. Be aware that the &#x60;id&#x60; of a pull request returned from \&quot;Issues\&quot; endpoints will be an _issue id_. To find out the pull request id, use the \&quot;[List pull requests](https://docs.github.com/rest/reference/pulls#list-pull-requests)\&quot; endpoint.
    *
    * @return IssueApiModel
    */
    suspend fun issuesGet(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int): IssueApiModel

    /**
    * Get an issue comment
    *
    * 
    *
    * @return IssueMinusCommentApiModel
    */
    suspend fun issuesGetComment(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, commentId: kotlin.Int): IssueMinusCommentApiModel

    /**
    * Get an issue event
    *
    * 
    *
    * @return IssueMinusEventApiModel
    */
    suspend fun issuesGetEvent(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, eventId: kotlin.Int): IssueMinusEventApiModel

    /**
    * Get a label
    *
    * 
    *
    * @return LabelApiModel
    */
    suspend fun issuesGetLabel(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, name: kotlin.String): LabelApiModel

    /**
    * Get a milestone
    *
    * 
    *
    * @return MilestoneApiModel
    */
    suspend fun issuesGetMilestone(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, milestoneNumber: kotlin.Int): MilestoneApiModel

    /**
    * List issues assigned to the authenticated user
    *
    * List issues assigned to the authenticated user across all visible repositories including owned repositories, member repositories, and organization repositories. You can use the &#x60;filter&#x60; query parameter to fetch issues that are not necessarily assigned to you.   **Note**: GitHub&#39;s REST API v3 considers every pull request an issue, but not every issue is a pull request. For this reason, \&quot;Issues\&quot; endpoints may return both issues and pull requests in the response. You can identify pull requests by the &#x60;pull_request&#x60; key. Be aware that the &#x60;id&#x60; of a pull request returned from \&quot;Issues\&quot; endpoints will be an _issue id_. To find out the pull request id, use the \&quot;[List pull requests](https://docs.github.com/rest/reference/pulls#list-pull-requests)\&quot; endpoint.
    *
    * @return kotlin.collections.List<IssueApiModel>
    */
    suspend fun issuesList(accessToken: String? = null, filter: kotlin.String? = null, state: kotlin.String? = null, labels: kotlin.String? = null, sort: kotlin.String? = null, direction: kotlin.String? = null, since: kotlin.String? = null, collab: kotlin.Boolean? = null, orgs: kotlin.Boolean? = null, owned: kotlin.Boolean? = null, pulls: kotlin.Boolean? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<IssueApiModel>

    /**
    * List assignees
    *
    * Lists the [available assignees](https://docs.github.com/articles/assigning-issues-and-pull-requests-to-other-github-users/) for issues in a repository.
    *
    * @return kotlin.collections.List<SimpleMinusUserApiModel>
    */
    suspend fun issuesListAssignees(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<SimpleMinusUserApiModel>

    /**
    * List issue comments
    *
    * Issue Comments are ordered by ascending ID.
    *
    * @return kotlin.collections.List<IssueMinusCommentApiModel>
    */
    suspend fun issuesListComments(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, since: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<IssueMinusCommentApiModel>

    /**
    * List issue comments for a repository
    *
    * By default, Issue Comments are ordered by ascending ID.
    *
    * @return kotlin.collections.List<IssueMinusCommentApiModel>
    */
    suspend fun issuesListCommentsForRepo(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, sort: kotlin.String? = null, direction: kotlin.String? = null, since: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<IssueMinusCommentApiModel>

    /**
    * List issue events
    *
    * 
    *
    * @return kotlin.collections.List<LabeledMinusIssueMinusEventApiModel>
    */
    suspend fun issuesListEvents(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<LabeledMinusIssueMinusEventApiModel>

    /**
    * List issue events for a repository
    *
    * 
    *
    * @return kotlin.collections.List<IssueMinusEventApiModel>
    */
    suspend fun issuesListEventsForRepo(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<IssueMinusEventApiModel>

    /**
    * List user account issues assigned to the authenticated user
    *
    * List issues across owned and member repositories assigned to the authenticated user.  **Note**: GitHub&#39;s REST API v3 considers every pull request an issue, but not every issue is a pull request. For this reason, \&quot;Issues\&quot; endpoints may return both issues and pull requests in the response. You can identify pull requests by the &#x60;pull_request&#x60; key. Be aware that the &#x60;id&#x60; of a pull request returned from \&quot;Issues\&quot; endpoints will be an _issue id_. To find out the pull request id, use the \&quot;[List pull requests](https://docs.github.com/rest/reference/pulls#list-pull-requests)\&quot; endpoint.
    *
    * @return kotlin.collections.List<IssueApiModel>
    */
    suspend fun issuesListForAuthenticatedUser(accessToken: String? = null, filter: kotlin.String? = null, state: kotlin.String? = null, labels: kotlin.String? = null, sort: kotlin.String? = null, direction: kotlin.String? = null, since: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<IssueApiModel>

    /**
    * List organization issues assigned to the authenticated user
    *
    * List issues in an organization assigned to the authenticated user.  **Note**: GitHub&#39;s REST API v3 considers every pull request an issue, but not every issue is a pull request. For this reason, \&quot;Issues\&quot; endpoints may return both issues and pull requests in the response. You can identify pull requests by the &#x60;pull_request&#x60; key. Be aware that the &#x60;id&#x60; of a pull request returned from \&quot;Issues\&quot; endpoints will be an _issue id_. To find out the pull request id, use the \&quot;[List pull requests](https://docs.github.com/rest/reference/pulls#list-pull-requests)\&quot; endpoint.
    *
    * @return kotlin.collections.List<IssueApiModel>
    */
    suspend fun issuesListForOrg(accessToken: String? = null, org: kotlin.String, filter: kotlin.String? = null, state: kotlin.String? = null, labels: kotlin.String? = null, sort: kotlin.String? = null, direction: kotlin.String? = null, since: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<IssueApiModel>

    /**
    * List repository issues
    *
    * List issues in a repository.  **Note**: GitHub&#39;s REST API v3 considers every pull request an issue, but not every issue is a pull request. For this reason, \&quot;Issues\&quot; endpoints may return both issues and pull requests in the response. You can identify pull requests by the &#x60;pull_request&#x60; key. Be aware that the &#x60;id&#x60; of a pull request returned from \&quot;Issues\&quot; endpoints will be an _issue id_. To find out the pull request id, use the \&quot;[List pull requests](https://docs.github.com/rest/reference/pulls#list-pull-requests)\&quot; endpoint.
    *
    * @return kotlin.collections.List<IssueApiModel>
    */
    suspend fun issuesListForRepo(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, milestone: kotlin.String? = null, state: kotlin.String? = null, assignee: kotlin.String? = null, creator: kotlin.String? = null, mentioned: kotlin.String? = null, labels: kotlin.String? = null, sort: kotlin.String? = null, direction: kotlin.String? = null, since: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<IssueApiModel>

    /**
    * List labels for issues in a milestone
    *
    * 
    *
    * @return kotlin.collections.List<LabelApiModel>
    */
    suspend fun issuesListLabelsForMilestone(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, milestoneNumber: kotlin.Int, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<LabelApiModel>

    /**
    * List labels for a repository
    *
    * 
    *
    * @return kotlin.collections.List<LabelApiModel>
    */
    suspend fun issuesListLabelsForRepo(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<LabelApiModel>

    /**
    * List milestones
    *
    * 
    *
    * @return kotlin.collections.List<MilestoneApiModel>
    */
    suspend fun issuesListMilestones(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, state: kotlin.String? = null, sort: kotlin.String? = null, direction: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<MilestoneApiModel>

    /**
    * Lock an issue
    *
    * Users with push access can lock an issue or pull request&#39;s conversation.  Note that, if you choose not to pass any parameters, you&#39;ll need to set &#x60;Content-Length&#x60; to zero when calling out to this endpoint. For more information, see \&quot;[HTTP verbs](https://docs.github.com/rest/overview/resources-in-the-rest-api#http-verbs).\&quot;
    *
    * @param request  (optional)
    * @return void
    */
    suspend fun issuesLock(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject106ApiModel)

    /**
    * Remove assignees from an issue
    *
    * Removes one or more assignees from an issue.
    *
    * @param request  (optional)
    * @return IssueApiModel
    */
    suspend fun issuesRemoveAssignees(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject104ApiModel): IssueApiModel

    /**
    * Remove a label from an issue
    *
    * Removes the specified label from the issue, and returns the remaining labels on the issue. This endpoint returns a &#x60;404 Not Found&#x60; status if the label does not exist.
    *
    * @return kotlin.collections.List<LabelApiModel>
    */
    suspend fun issuesRemoveLabel(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, name: kotlin.String): kotlin.collections.List<LabelApiModel>

    /**
    * Unlock an issue
    *
    * Users with push access can unlock an issue&#39;s conversation.
    *
    * @return void
    */
    suspend fun issuesUnlock(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int)

    /**
    * Update an issue
    *
    * Issue owners and users with push access can edit an issue.
    *
    * @param request  (optional)
    * @return IssueApiModel
    */
    suspend fun issuesUpdate(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject102ApiModel): IssueApiModel

    /**
    * Update an issue comment
    *
    * 
    *
    * @param request 
    * @return IssueMinusCommentApiModel
    */
    suspend fun issuesUpdateComment(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, commentId: kotlin.Int, request: InlineObject100ApiModel): IssueMinusCommentApiModel

    /**
    * Update a label
    *
    * 
    *
    * @param request  (optional)
    * @return LabelApiModel
    */
    suspend fun issuesUpdateLabel(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, name: kotlin.String, request: InlineObject110ApiModel): LabelApiModel

    /**
    * Update a milestone
    *
    * 
    *
    * @param request  (optional)
    * @return MilestoneApiModel
    */
    suspend fun issuesUpdateMilestone(accessToken: String? = null, owner: kotlin.String, repo: kotlin.String, milestoneNumber: kotlin.Int, request: InlineObject114ApiModel): MilestoneApiModel

}

class HttpClientIssuesApi(private val httpClientProvider: HttpClientProvider) : IssuesApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun issuesAddAssignees(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject103ApiModel): IssueApiModel {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}/assignees".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun issuesCheckUserCanBeAssigned(accessToken: String?, owner: kotlin.String, repo: kotlin.String, assignee: kotlin.String) {
        val path = "/repos/{owner}/{repo}/assignees/{assignee}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"assignee"+"}", "$assignee")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun issuesCreate(accessToken: String?, owner: kotlin.String, repo: kotlin.String, request: InlineObject99ApiModel): IssueApiModel {
        val path = "/repos/{owner}/{repo}/issues".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun issuesCreateComment(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject105ApiModel): IssueMinusCommentApiModel {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}/comments".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun issuesCreateLabel(accessToken: String?, owner: kotlin.String, repo: kotlin.String, request: InlineObject109ApiModel): LabelApiModel {
        val path = "/repos/{owner}/{repo}/labels".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun issuesCreateMilestone(accessToken: String?, owner: kotlin.String, repo: kotlin.String, request: InlineObject113ApiModel): MilestoneApiModel {
        val path = "/repos/{owner}/{repo}/milestones".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun issuesDeleteComment(accessToken: String?, owner: kotlin.String, repo: kotlin.String, commentId: kotlin.Int) {
        val path = "/repos/{owner}/{repo}/issues/comments/{comment_id}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"comment_id"+"}", "$commentId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun issuesDeleteLabel(accessToken: String?, owner: kotlin.String, repo: kotlin.String, name: kotlin.String) {
        val path = "/repos/{owner}/{repo}/labels/{name}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"name"+"}", "$name")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun issuesDeleteMilestone(accessToken: String?, owner: kotlin.String, repo: kotlin.String, milestoneNumber: kotlin.Int) {
        val path = "/repos/{owner}/{repo}/milestones/{milestone_number}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"milestone_number"+"}", "$milestoneNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun issuesGet(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int): IssueApiModel {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun issuesGetComment(accessToken: String?, owner: kotlin.String, repo: kotlin.String, commentId: kotlin.Int): IssueMinusCommentApiModel {
        val path = "/repos/{owner}/{repo}/issues/comments/{comment_id}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"comment_id"+"}", "$commentId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun issuesGetEvent(accessToken: String?, owner: kotlin.String, repo: kotlin.String, eventId: kotlin.Int): IssueMinusEventApiModel {
        val path = "/repos/{owner}/{repo}/issues/events/{event_id}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"event_id"+"}", "$eventId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun issuesGetLabel(accessToken: String?, owner: kotlin.String, repo: kotlin.String, name: kotlin.String): LabelApiModel {
        val path = "/repos/{owner}/{repo}/labels/{name}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"name"+"}", "$name")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun issuesGetMilestone(accessToken: String?, owner: kotlin.String, repo: kotlin.String, milestoneNumber: kotlin.Int): MilestoneApiModel {
        val path = "/repos/{owner}/{repo}/milestones/{milestone_number}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"milestone_number"+"}", "$milestoneNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun issuesList(accessToken: String?, filter: kotlin.String?, state: kotlin.String?, labels: kotlin.String?, sort: kotlin.String?, direction: kotlin.String?, since: kotlin.String?, collab: kotlin.Boolean?, orgs: kotlin.Boolean?, owned: kotlin.Boolean?, pulls: kotlin.Boolean?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<IssueApiModel> {
        val path = "/issues"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("filter", filter)
            parameter("state", state)
            parameter("labels", labels)
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("since", since)
            parameter("collab", collab)
            parameter("orgs", orgs)
            parameter("owned", owned)
            parameter("pulls", pulls)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListAssignees(accessToken: String?, owner: kotlin.String, repo: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<SimpleMinusUserApiModel> {
        val path = "/repos/{owner}/{repo}/assignees".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListComments(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, since: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<IssueMinusCommentApiModel> {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}/comments".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("since", since)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListCommentsForRepo(accessToken: String?, owner: kotlin.String, repo: kotlin.String, sort: kotlin.String?, direction: kotlin.String?, since: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<IssueMinusCommentApiModel> {
        val path = "/repos/{owner}/{repo}/issues/comments".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("since", since)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListEvents(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<LabeledMinusIssueMinusEventApiModel> {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}/events".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListEventsForRepo(accessToken: String?, owner: kotlin.String, repo: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<IssueMinusEventApiModel> {
        val path = "/repos/{owner}/{repo}/issues/events".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListForAuthenticatedUser(accessToken: String?, filter: kotlin.String?, state: kotlin.String?, labels: kotlin.String?, sort: kotlin.String?, direction: kotlin.String?, since: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<IssueApiModel> {
        val path = "/user/issues"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("filter", filter)
            parameter("state", state)
            parameter("labels", labels)
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("since", since)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListForOrg(accessToken: String?, org: kotlin.String, filter: kotlin.String?, state: kotlin.String?, labels: kotlin.String?, sort: kotlin.String?, direction: kotlin.String?, since: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<IssueApiModel> {
        val path = "/orgs/{org}/issues".replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("filter", filter)
            parameter("state", state)
            parameter("labels", labels)
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("since", since)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListForRepo(accessToken: String?, owner: kotlin.String, repo: kotlin.String, milestone: kotlin.String?, state: kotlin.String?, assignee: kotlin.String?, creator: kotlin.String?, mentioned: kotlin.String?, labels: kotlin.String?, sort: kotlin.String?, direction: kotlin.String?, since: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<IssueApiModel> {
        val path = "/repos/{owner}/{repo}/issues".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("milestone", milestone)
            parameter("state", state)
            parameter("assignee", assignee)
            parameter("creator", creator)
            parameter("mentioned", mentioned)
            parameter("labels", labels)
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("since", since)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListLabelsForMilestone(accessToken: String?, owner: kotlin.String, repo: kotlin.String, milestoneNumber: kotlin.Int, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<LabelApiModel> {
        val path = "/repos/{owner}/{repo}/milestones/{milestone_number}/labels".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"milestone_number"+"}", "$milestoneNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListLabelsForRepo(accessToken: String?, owner: kotlin.String, repo: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<LabelApiModel> {
        val path = "/repos/{owner}/{repo}/labels".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesListMilestones(accessToken: String?, owner: kotlin.String, repo: kotlin.String, state: kotlin.String?, sort: kotlin.String?, direction: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<MilestoneApiModel> {
        val path = "/repos/{owner}/{repo}/milestones".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("state", state)
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("perPage", perPage)
            parameter("page", page)
        }
    }

    override suspend fun issuesLock(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject106ApiModel) {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}/lock".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun issuesRemoveAssignees(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject104ApiModel): IssueApiModel {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}/assignees".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
            body = request
        }
    }

    override suspend fun issuesRemoveLabel(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, name: kotlin.String): kotlin.collections.List<LabelApiModel> {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}/labels/{name}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber").replace("{"+"name"+"}", "$name")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun issuesUnlock(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int) {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}/lock".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun issuesUpdate(accessToken: String?, owner: kotlin.String, repo: kotlin.String, issueNumber: kotlin.Int, request: InlineObject102ApiModel): IssueApiModel {
        val path = "/repos/{owner}/{repo}/issues/{issue_number}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"issue_number"+"}", "$issueNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

    override suspend fun issuesUpdateComment(accessToken: String?, owner: kotlin.String, repo: kotlin.String, commentId: kotlin.Int, request: InlineObject100ApiModel): IssueMinusCommentApiModel {
        val path = "/repos/{owner}/{repo}/issues/comments/{comment_id}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"comment_id"+"}", "$commentId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

    override suspend fun issuesUpdateLabel(accessToken: String?, owner: kotlin.String, repo: kotlin.String, name: kotlin.String, request: InlineObject110ApiModel): LabelApiModel {
        val path = "/repos/{owner}/{repo}/labels/{name}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"name"+"}", "$name")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

    override suspend fun issuesUpdateMilestone(accessToken: String?, owner: kotlin.String, repo: kotlin.String, milestoneNumber: kotlin.Int, request: InlineObject114ApiModel): MilestoneApiModel {
        val path = "/repos/{owner}/{repo}/milestones/{milestone_number}".replace("{"+"owner"+"}", "$owner").replace("{"+"repo"+"}", "$repo").replace("{"+"milestone_number"+"}", "$milestoneNumber")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

}
