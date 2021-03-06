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

package io.github.gmvalentino8.github.sample.remote.apis

import io.ktor.client.request.request
import io.github.gmvalentino8.github.sample.remote.models.*
import io.github.gmvalentino8.github.sample.remote.core.HttpClientProvider
import io.ktor.client.request.parameter
import io.ktor.http.HttpMethod

interface ActivityApi {
    /**
    * Check if a repository is starred by the authenticated user
    *
    * 
    *
    * @return void
    */
    suspend fun activityCheckRepoIsStarredByAuthenticatedUser(accessToken: String? = null, repoName: kotlin.String)

    /**
    * Delete a repository subscription
    *
    * This endpoint should only be used to stop watching a repository. To control whether or not you wish to receive notifications from a repository, [set the repository&#39;s subscription manually](https://docs.github.com/rest/reference/activity#set-a-repository-subscription).
    *
    * @return void
    */
    suspend fun activityDeleteRepoSubscription(accessToken: String? = null, repoName: kotlin.String)

    /**
    * Delete a thread subscription
    *
    * Mutes all future notifications for a conversation until you comment on the thread or get an **@mention**. If you are watching the repository of the thread, you will still receive notifications. To ignore future notifications for a repository you are watching, use the [Set a thread subscription](https://docs.github.com/rest/reference/activity#set-a-thread-subscription) endpoint and set &#x60;ignore&#x60; to &#x60;true&#x60;.
    *
    * @return void
    */
    suspend fun activityDeleteThreadSubscription(accessToken: String? = null, threadId: kotlin.Int)

    /**
    * Get feeds
    *
    * GitHub provides several timeline resources in [Atom](http://en.wikipedia.org/wiki/Atom_(standard)) format. The Feeds API lists all the feeds available to the authenticated user:  *   **Timeline**: The GitHub global public timeline *   **User**: The public timeline for any user, using [URI template](https://docs.github.com/rest/overview/resources-in-the-rest-api#hypermedia) *   **Current user public**: The public timeline for the authenticated user *   **Current user**: The private timeline for the authenticated user *   **Current user actor**: The private timeline for activity created by the authenticated user *   **Current user organizations**: The private timeline for the organizations the authenticated user is a member of. *   **Security advisories**: A collection of public announcements that provide information about security-related vulnerabilities in software on GitHub.  **Note**: Private feeds are only returned when [authenticating via Basic Auth](https://docs.github.com/rest/overview/other-authentication-methods#basic-authentication) since current feed URIs use the older, non revocable auth tokens.
    *
    * @return FeedApiModel
    */
    suspend fun activityGetFeeds(accessToken: String? = null): FeedApiModel

    /**
    * Get a repository subscription
    *
    * 
    *
    * @return RepositoryMinusSubscriptionApiModel
    */
    suspend fun activityGetRepoSubscription(accessToken: String? = null, repoName: kotlin.String): RepositoryMinusSubscriptionApiModel

    /**
    * Get a thread
    *
    * 
    *
    * @return ThreadApiModel
    */
    suspend fun activityGetThread(accessToken: String? = null, threadId: kotlin.Int): ThreadApiModel

    /**
    * Get a thread subscription for the authenticated user
    *
    * This checks to see if the current user is subscribed to a thread. You can also [get a repository subscription](https://docs.github.com/rest/reference/activity#get-a-repository-subscription).  Note that subscriptions are only generated if a user is participating in a conversation--for example, they&#39;ve replied to the thread, were **@mentioned**, or manually subscribe to a thread.
    *
    * @return ThreadMinusSubscriptionApiModel
    */
    suspend fun activityGetThreadSubscriptionForAuthenticatedUser(accessToken: String? = null, threadId: kotlin.Int): ThreadMinusSubscriptionApiModel

    /**
    * List events for the authenticated user
    *
    * If you are authenticated as the given user, you will see your private events. Otherwise, you&#39;ll only see public events.
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListEventsForAuthenticatedUser(accessToken: String? = null, username: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List notifications for the authenticated user
    *
    * List all notifications for the current user, sorted by most recently updated.
    *
    * @return kotlin.collections.List<ThreadApiModel>
    */
    suspend fun activityListNotificationsForAuthenticatedUser(accessToken: String? = null, all: kotlin.Boolean? = null, participating: kotlin.Boolean? = null, since: kotlin.String? = null, before: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<ThreadApiModel>

    /**
    * List organization events for the authenticated user
    *
    * This is the user&#39;s organization dashboard. You must be authenticated as the user to view this.
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListOrgEventsForAuthenticatedUser(accessToken: String? = null, username: kotlin.String, org: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List public events
    *
    * We delay the public events feed by five minutes, which means the most recent event returned by the public events API actually occurred at least five minutes ago.
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListPublicEvents(accessToken: String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List public events for a network of repositories
    *
    * 
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListPublicEventsForRepoNetwork(accessToken: String? = null, repoName: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List public events for a user
    *
    * 
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListPublicEventsForUser(accessToken: String? = null, username: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List public organization events
    *
    * 
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListPublicOrgEvents(accessToken: String? = null, org: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List events received by the authenticated user
    *
    * These are events that you&#39;ve received by watching repos and following users. If you are authenticated as the given user, you will see private events. Otherwise, you&#39;ll only see public events.
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListReceivedEventsForUser(accessToken: String? = null, username: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List public events received by a user
    *
    * 
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListReceivedPublicEventsForUser(accessToken: String? = null, username: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List repository events
    *
    * 
    *
    * @return kotlin.collections.List<EventApiModel>
    */
    suspend fun activityListRepoEvents(accessToken: String? = null, repoName: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<EventApiModel>

    /**
    * List repository notifications for the authenticated user
    *
    * List all notifications for the current user.
    *
    * @return kotlin.collections.List<ThreadApiModel>
    */
    suspend fun activityListRepoNotificationsForAuthenticatedUser(accessToken: String? = null, repoName: kotlin.String, all: kotlin.Boolean? = null, participating: kotlin.Boolean? = null, since: kotlin.String? = null, before: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<ThreadApiModel>

    /**
    * List repositories starred by the authenticated user
    *
    * Lists repositories the authenticated user has starred.  You can also find out _when_ stars were created by passing the following custom [media type](https://docs.github.com/rest/overview/media-types/) via the &#x60;Accept&#x60; header:
    *
    * @return kotlin.collections.List<RepositoryApiModel>
    */
    suspend fun activityListReposStarredByAuthenticatedUser(accessToken: String? = null, sort: kotlin.String? = null, direction: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<RepositoryApiModel>

    /**
    * List repositories watched by a user
    *
    * Lists repositories a user is watching.
    *
    * @return kotlin.collections.List<MinimalMinusRepositoryApiModel>
    */
    suspend fun activityListReposWatchedByUser(accessToken: String? = null, username: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<MinimalMinusRepositoryApiModel>

    /**
    * List repositories watched by the authenticated user
    *
    * Lists repositories the authenticated user is watching.
    *
    * @return kotlin.collections.List<MinimalMinusRepositoryApiModel>
    */
    suspend fun activityListWatchedReposForAuthenticatedUser(accessToken: String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<MinimalMinusRepositoryApiModel>

    /**
    * List watchers
    *
    * Lists the people watching the specified repository.
    *
    * @return kotlin.collections.List<SimpleMinusUserApiModel>
    */
    suspend fun activityListWatchersForRepo(accessToken: String? = null, repoName: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<SimpleMinusUserApiModel>

    /**
    * Mark notifications as read
    *
    * Marks all notifications as \&quot;read\&quot; removes it from the [default view on GitHub](https://github.com/notifications). If the number of notifications is too large to complete in one request, you will receive a &#x60;202 Accepted&#x60; status and GitHub will run an asynchronous process to mark notifications as \&quot;read.\&quot; To check whether any \&quot;unread\&quot; notifications remain, you can use the [List notifications for the authenticated user](https://docs.github.com/rest/reference/activity#list-notifications-for-the-authenticated-user) endpoint and pass the query parameter &#x60;all&#x3D;false&#x60;.
    *
    * @param request  (optional)
    * @return InlineResponse202ApiModel
    */
    suspend fun activityMarkNotificationsAsRead(accessToken: String? = null, request: InlineObject15ApiModel): InlineResponse202ApiModel

    /**
    * Mark repository notifications as read
    *
    * Marks all notifications in a repository as \&quot;read\&quot; removes them from the [default view on GitHub](https://github.com/notifications). If the number of notifications is too large to complete in one request, you will receive a &#x60;202 Accepted&#x60; status and GitHub will run an asynchronous process to mark notifications as \&quot;read.\&quot; To check whether any \&quot;unread\&quot; notifications remain, you can use the [List repository notifications for the authenticated user](https://docs.github.com/rest/reference/activity#list-repository-notifications-for-the-authenticated-user) endpoint and pass the query parameter &#x60;all&#x3D;false&#x60;.
    *
    * @param request  (optional)
    * @return InlineResponse2021ApiModel
    */
    suspend fun activityMarkRepoNotificationsAsRead(accessToken: String? = null, repoName: kotlin.String, request: InlineObject115ApiModel): InlineResponse2021ApiModel

    /**
    * Mark a thread as read
    *
    * 
    *
    * @return void
    */
    suspend fun activityMarkThreadAsRead(accessToken: String? = null, threadId: kotlin.Int)

    /**
    * Set a repository subscription
    *
    * If you would like to watch a repository, set &#x60;subscribed&#x60; to &#x60;true&#x60;. If you would like to ignore notifications made within a repository, set &#x60;ignored&#x60; to &#x60;true&#x60;. If you would like to stop watching a repository, [delete the repository&#39;s subscription](https://docs.github.com/rest/reference/activity#delete-a-repository-subscription) completely.
    *
    * @param request  (optional)
    * @return RepositoryMinusSubscriptionApiModel
    */
    suspend fun activitySetRepoSubscription(accessToken: String? = null, repoName: kotlin.String, request: InlineObject137ApiModel): RepositoryMinusSubscriptionApiModel

    /**
    * Set a thread subscription
    *
    * If you are watching a repository, you receive notifications for all threads by default. Use this endpoint to ignore future notifications for threads until you comment on the thread or get an **@mention**.  You can also use this endpoint to subscribe to threads that you are currently not receiving notifications for or to subscribed to threads that you have previously ignored.  Unsubscribing from a conversation in a repository that you are not watching is functionally equivalent to the [Delete a thread subscription](https://docs.github.com/rest/reference/activity#delete-a-thread-subscription) endpoint.
    *
    * @param request  (optional)
    * @return ThreadMinusSubscriptionApiModel
    */
    suspend fun activitySetThreadSubscription(accessToken: String? = null, threadId: kotlin.Int, request: InlineObject16ApiModel): ThreadMinusSubscriptionApiModel

    /**
    * Star a repository for the authenticated user
    *
    * Note that you&#39;ll need to set &#x60;Content-Length&#x60; to zero when calling out to this endpoint. For more information, see \&quot;[HTTP verbs](https://docs.github.com/rest/overview/resources-in-the-rest-api#http-verbs).\&quot;
    *
    * @return void
    */
    suspend fun activityStarRepoForAuthenticatedUser(accessToken: String? = null, repoName: kotlin.String)

    /**
    * Unstar a repository for the authenticated user
    *
    * 
    *
    * @return void
    */
    suspend fun activityUnstarRepoForAuthenticatedUser(accessToken: String? = null, repoName: kotlin.String)

}

class HttpClientActivityApi(private val httpClientProvider: HttpClientProvider) : ActivityApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun activityCheckRepoIsStarredByAuthenticatedUser(accessToken: String?, repoName: kotlin.String) {
        val path = "/user/starred/{repo_name}".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun activityDeleteRepoSubscription(accessToken: String?, repoName: kotlin.String) {
        val path = "/repos/{repo_name}/subscription".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun activityDeleteThreadSubscription(accessToken: String?, threadId: kotlin.Int) {
        val path = "/notifications/threads/{thread_id}/subscription".replace("{"+"thread_id"+"}", "$threadId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun activityGetFeeds(accessToken: String?): FeedApiModel {
        val path = "/feeds"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun activityGetRepoSubscription(accessToken: String?, repoName: kotlin.String): RepositoryMinusSubscriptionApiModel {
        val path = "/repos/{repo_name}/subscription".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun activityGetThread(accessToken: String?, threadId: kotlin.Int): ThreadApiModel {
        val path = "/notifications/threads/{thread_id}".replace("{"+"thread_id"+"}", "$threadId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun activityGetThreadSubscriptionForAuthenticatedUser(accessToken: String?, threadId: kotlin.Int): ThreadMinusSubscriptionApiModel {
        val path = "/notifications/threads/{thread_id}/subscription".replace("{"+"thread_id"+"}", "$threadId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun activityListEventsForAuthenticatedUser(accessToken: String?, username: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/users/{username}/events".replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListNotificationsForAuthenticatedUser(accessToken: String?, all: kotlin.Boolean?, participating: kotlin.Boolean?, since: kotlin.String?, before: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<ThreadApiModel> {
        val path = "/notifications"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("all", all)
            parameter("participating", participating)
            parameter("since", since)
            parameter("before", before)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListOrgEventsForAuthenticatedUser(accessToken: String?, username: kotlin.String, org: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/users/{username}/events/orgs/{org}".replace("{"+"username"+"}", "$username").replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListPublicEvents(accessToken: String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/events"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListPublicEventsForRepoNetwork(accessToken: String?, repoName: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/networks/{repo_name}/events".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListPublicEventsForUser(accessToken: String?, username: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/users/{username}/events/public".replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListPublicOrgEvents(accessToken: String?, org: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/orgs/{org}/events".replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListReceivedEventsForUser(accessToken: String?, username: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/users/{username}/received_events".replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListReceivedPublicEventsForUser(accessToken: String?, username: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/users/{username}/received_events/public".replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListRepoEvents(accessToken: String?, repoName: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<EventApiModel> {
        val path = "/repos/{repo_name}/events".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListRepoNotificationsForAuthenticatedUser(accessToken: String?, repoName: kotlin.String, all: kotlin.Boolean?, participating: kotlin.Boolean?, since: kotlin.String?, before: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<ThreadApiModel> {
        val path = "/repos/{repo_name}/notifications".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("all", all)
            parameter("participating", participating)
            parameter("since", since)
            parameter("before", before)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListReposStarredByAuthenticatedUser(accessToken: String?, sort: kotlin.String?, direction: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<RepositoryApiModel> {
        val path = "/user/starred"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("sort", sort)
            parameter("direction", direction)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListReposWatchedByUser(accessToken: String?, username: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<MinimalMinusRepositoryApiModel> {
        val path = "/users/{username}/subscriptions".replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListWatchedReposForAuthenticatedUser(accessToken: String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<MinimalMinusRepositoryApiModel> {
        val path = "/user/subscriptions"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityListWatchersForRepo(accessToken: String?, repoName: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<SimpleMinusUserApiModel> {
        val path = "/repos/{repo_name}/subscribers".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun activityMarkNotificationsAsRead(accessToken: String?, request: InlineObject15ApiModel): InlineResponse202ApiModel {
        val path = "/notifications"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun activityMarkRepoNotificationsAsRead(accessToken: String?, repoName: kotlin.String, request: InlineObject115ApiModel): InlineResponse2021ApiModel {
        val path = "/repos/{repo_name}/notifications".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun activityMarkThreadAsRead(accessToken: String?, threadId: kotlin.Int) {
        val path = "/notifications/threads/{thread_id}".replace("{"+"thread_id"+"}", "$threadId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
        }
    }

    override suspend fun activitySetRepoSubscription(accessToken: String?, repoName: kotlin.String, request: InlineObject137ApiModel): RepositoryMinusSubscriptionApiModel {
        val path = "/repos/{repo_name}/subscription".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun activitySetThreadSubscription(accessToken: String?, threadId: kotlin.Int, request: InlineObject16ApiModel): ThreadMinusSubscriptionApiModel {
        val path = "/notifications/threads/{thread_id}/subscription".replace("{"+"thread_id"+"}", "$threadId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun activityStarRepoForAuthenticatedUser(accessToken: String?, repoName: kotlin.String) {
        val path = "/user/starred/{repo_name}".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
        }
    }

    override suspend fun activityUnstarRepoForAuthenticatedUser(accessToken: String?, repoName: kotlin.String) {
        val path = "/user/starred/{repo_name}".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

}
