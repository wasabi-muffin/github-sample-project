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

interface SearchApi {
    /**
    * Search code
    *
    * Searches for query terms inside of a file. This method returns up to 100 results [per page](https://docs.github.com/rest/overview/resources-in-the-rest-api#pagination).  When searching for code, you can get text match metadata for the file **content** and file **path** fields when you pass the &#x60;text-match&#x60; media type. For more details about how to receive highlighted search results, see [Text match metadata](https://docs.github.com/rest/reference/search#text-match-metadata).  For example, if you want to find the definition of the &#x60;addClass&#x60; function inside [jQuery](https://github.com/jquery/jquery) repository, your query would look something like this:  &#x60;q&#x3D;addClass+in:file+language:js+repo:jquery/jquery&#x60;  This query searches for the keyword &#x60;addClass&#x60; within a file&#39;s contents. The query limits the search to files where the language is JavaScript in the &#x60;jquery/jquery&#x60; repository.  #### Considerations for code search  Due to the complexity of searching code, there are a few restrictions on how searches are performed:  *   Only the _default branch_ is considered. In most cases, this will be the &#x60;master&#x60; branch. *   Only files smaller than 384 KB are searchable. *   You must always include at least one search term when searching source code. For example, searching for [&#x60;language:go&#x60;](https://github.com/search?utf8&#x3D;%E2%9C%93&amp;q&#x3D;language%3Ago&amp;type&#x3D;Code) is not valid, while [&#x60;amazing language:go&#x60;](https://github.com/search?utf8&#x3D;%E2%9C%93&amp;q&#x3D;amazing+language%3Ago&amp;type&#x3D;Code) is.
    *
    * @return InlineResponse20024ApiModel
    */
    suspend fun searchCode(accessToken: String? = null, q: kotlin.String? = null, sort: kotlin.String? = null, order: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): InlineResponse20024ApiModel

    /**
    * Search commits
    *
    * Find commits via various criteria on the default branch (usually &#x60;master&#x60;). This method returns up to 100 results [per page](https://docs.github.com/rest/overview/resources-in-the-rest-api#pagination).  When searching for commits, you can get text match metadata for the **message** field when you provide the &#x60;text-match&#x60; media type. For more details about how to receive highlighted search results, see [Text match metadata](https://docs.github.com/rest/reference/search#text-match-metadata).  For example, if you want to find commits related to CSS in the [octocat/Spoon-Knife](https://github.com/octocat/Spoon-Knife) repository. Your query would look something like this:  &#x60;q&#x3D;repo:octocat/Spoon-Knife+css&#x60;
    *
    * @return InlineResponse20025ApiModel
    */
    suspend fun searchCommits(accessToken: String? = null, q: kotlin.String? = null, sort: kotlin.String? = null, order: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): InlineResponse20025ApiModel

    /**
    * Search issues and pull requests
    *
    * Find issues by state and keyword. This method returns up to 100 results [per page](https://docs.github.com/rest/overview/resources-in-the-rest-api#pagination).  When searching for issues, you can get text match metadata for the issue **title**, issue **body**, and issue **comment body** fields when you pass the &#x60;text-match&#x60; media type. For more details about how to receive highlighted search results, see [Text match metadata](https://docs.github.com/rest/reference/search#text-match-metadata).  For example, if you want to find the oldest unresolved Python bugs on Windows. Your query might look something like this.  &#x60;q&#x3D;windows+label:bug+language:python+state:open&amp;sort&#x3D;created&amp;order&#x3D;asc&#x60;  This query searches for the keyword &#x60;windows&#x60;, within any open issue that is labeled as &#x60;bug&#x60;. The search runs across repositories whose primary language is Python. The results are sorted by creation date in ascending order, which means the oldest issues appear first in the search results.  **Note:** For [user-to-server](https://docs.github.com/developers/apps/identifying-and-authorizing-users-for-github-apps#user-to-server-requests) GitHub App requests, you can&#39;t retrieve a combination of issues and pull requests in a single query. Requests that don&#39;t include the &#x60;is:issue&#x60; or &#x60;is:pull-request&#x60; qualifier will receive an HTTP &#x60;422 Unprocessable Entity&#x60; response. To get results for both issues and pull requests, you must send separate queries for issues and pull requests. For more information about the &#x60;is&#x60; qualifier, see \&quot;[Searching only issues or pull requests](https://docs.github.com/github/searching-for-information-on-github/searching-issues-and-pull-requests#search-only-issues-or-pull-requests).\&quot;
    *
    * @return InlineResponse20026ApiModel
    */
    suspend fun searchIssuesAndPullRequests(accessToken: String? = null, q: kotlin.String? = null, sort: kotlin.String? = null, order: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): InlineResponse20026ApiModel

    /**
    * Search labels
    *
    * Find labels in a repository with names or descriptions that match search keywords. Returns up to 100 results [per page](https://docs.github.com/rest/overview/resources-in-the-rest-api#pagination).  When searching for labels, you can get text match metadata for the label **name** and **description** fields when you pass the &#x60;text-match&#x60; media type. For more details about how to receive highlighted search results, see [Text match metadata](https://docs.github.com/rest/reference/search#text-match-metadata).  For example, if you want to find labels in the &#x60;linguist&#x60; repository that match &#x60;bug&#x60;, &#x60;defect&#x60;, or &#x60;enhancement&#x60;. Your query might look like this:  &#x60;q&#x3D;bug+defect+enhancement&amp;repository_id&#x3D;64778136&#x60;  The labels that best match the query appear first in the search results.
    *
    * @return InlineResponse20027ApiModel
    */
    suspend fun searchLabels(accessToken: String? = null, repositoryId: kotlin.Int? = null, q: kotlin.String? = null, sort: kotlin.String? = null, order: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): InlineResponse20027ApiModel

    /**
    * Search repositories
    *
    * Find repositories via various criteria. This method returns up to 100 results [per page](https://docs.github.com/rest/overview/resources-in-the-rest-api#pagination).  When searching for repositories, you can get text match metadata for the **name** and **description** fields when you pass the &#x60;text-match&#x60; media type. For more details about how to receive highlighted search results, see [Text match metadata](https://docs.github.com/rest/reference/search#text-match-metadata).  For example, if you want to search for popular Tetris repositories written in assembly code, your query might look like this:  &#x60;q&#x3D;tetris+language:assembly&amp;sort&#x3D;stars&amp;order&#x3D;desc&#x60;  This query searches for repositories with the word &#x60;tetris&#x60; in the name, the description, or the README. The results are limited to repositories where the primary language is assembly. The results are sorted by stars in descending order, so that the most popular repositories appear first in the search results.
    *
    * @return InlineResponse20028ApiModel
    */
    suspend fun searchRepos(accessToken: String? = null, q: kotlin.String? = null, sort: kotlin.String? = null, order: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): InlineResponse20028ApiModel

    /**
    * Search topics
    *
    * Find topics via various criteria. Results are sorted by best match. This method returns up to 100 results [per page](https://docs.github.com/rest/overview/resources-in-the-rest-api#pagination). See \&quot;[Searching topics](https://docs.github.com/articles/searching-topics/)\&quot; for a detailed list of qualifiers.  When searching for topics, you can get text match metadata for the topic&#39;s **short\\_description**, **description**, **name**, or **display\\_name** field when you pass the &#x60;text-match&#x60; media type. For more details about how to receive highlighted search results, see [Text match metadata](https://docs.github.com/rest/reference/search#text-match-metadata).  For example, if you want to search for topics related to Ruby that are featured on https://github.com/topics. Your query might look like this:  &#x60;q&#x3D;ruby+is:featured&#x60;  This query searches for topics with the keyword &#x60;ruby&#x60; and limits the results to find only topics that are featured. The topics that are the best match for the query appear first in the search results.
    *
    * @return InlineResponse20029ApiModel
    */
    suspend fun searchTopics(accessToken: String? = null, q: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): InlineResponse20029ApiModel

    /**
    * Search users
    *
    * Find users via various criteria. This method returns up to 100 results [per page](https://docs.github.com/rest/overview/resources-in-the-rest-api#pagination).  When searching for users, you can get text match metadata for the issue **login**, **email**, and **name** fields when you pass the &#x60;text-match&#x60; media type. For more details about highlighting search results, see [Text match metadata](https://docs.github.com/rest/reference/search#text-match-metadata). For more details about how to receive highlighted search results, see [Text match metadata](https://docs.github.com/rest/reference/search#text-match-metadata).  For example, if you&#39;re looking for a list of popular users, you might try this query:  &#x60;q&#x3D;tom+repos:%3E42+followers:%3E1000&#x60;  This query searches for users with the name &#x60;tom&#x60;. The results are restricted to users with more than 42 repositories and over 1,000 followers.
    *
    * @return InlineResponse20030ApiModel
    */
    suspend fun searchUsers(accessToken: String? = null, q: kotlin.String? = null, sort: kotlin.String? = null, order: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): InlineResponse20030ApiModel

}

class HttpClientSearchApi(private val httpClientProvider: HttpClientProvider) : SearchApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun searchCode(accessToken: String?, q: kotlin.String?, sort: kotlin.String?, order: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): InlineResponse20024ApiModel {
        val path = "/search/code"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("q", q)
            parameter("sort", sort)
            parameter("order", order)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun searchCommits(accessToken: String?, q: kotlin.String?, sort: kotlin.String?, order: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): InlineResponse20025ApiModel {
        val path = "/search/commits"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("q", q)
            parameter("sort", sort)
            parameter("order", order)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun searchIssuesAndPullRequests(accessToken: String?, q: kotlin.String?, sort: kotlin.String?, order: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): InlineResponse20026ApiModel {
        val path = "/search/issues"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("q", q)
            parameter("sort", sort)
            parameter("order", order)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun searchLabels(accessToken: String?, repositoryId: kotlin.Int?, q: kotlin.String?, sort: kotlin.String?, order: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): InlineResponse20027ApiModel {
        val path = "/search/labels"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("repository_id", repositoryId)
            parameter("q", q)
            parameter("sort", sort)
            parameter("order", order)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun searchRepos(accessToken: String?, q: kotlin.String?, sort: kotlin.String?, order: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): InlineResponse20028ApiModel {
        val path = "/search/repositories"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("q", q)
            parameter("sort", sort)
            parameter("order", order)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun searchTopics(accessToken: String?, q: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): InlineResponse20029ApiModel {
        val path = "/search/topics"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("q", q)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun searchUsers(accessToken: String?, q: kotlin.String?, sort: kotlin.String?, order: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): InlineResponse20030ApiModel {
        val path = "/search/users"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("q", q)
            parameter("sort", sort)
            parameter("order", order)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

}
