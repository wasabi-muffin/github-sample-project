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

interface ProjectsApi {
    /**
    * Add project collaborator
    *
    * Adds a collaborator to an organization project and sets their permission level. You must be an organization owner or a project &#x60;admin&#x60; to add a collaborator.
    *
    * @param request  (optional)
    * @return void
    */
    suspend fun projectsAddCollaborator(accessToken: String? = null, projectId: kotlin.Int, username: kotlin.String, request: InlineObject55ApiModel)

    /**
    * Create a project column
    *
    * 
    *
    * @param request 
    * @return ProjectMinusColumnApiModel
    */
    suspend fun projectsCreateColumn(accessToken: String? = null, projectId: kotlin.Int, request: InlineObject56ApiModel): ProjectMinusColumnApiModel

    /**
    * Create a user project
    *
    * 
    *
    * @param request 
    * @return ProjectApiModel
    */
    suspend fun projectsCreateForAuthenticatedUser(accessToken: String? = null, request: InlineObject170ApiModel): ProjectApiModel

    /**
    * Create an organization project
    *
    * Creates an organization project board. Returns a &#x60;404 Not Found&#x60; status if projects are disabled in the organization. If you do not have sufficient privileges to perform this action, a &#x60;401 Unauthorized&#x60; or &#x60;410 Gone&#x60; status is returned.
    *
    * @param request 
    * @return ProjectApiModel
    */
    suspend fun projectsCreateForOrg(accessToken: String? = null, org: kotlin.String, request: InlineObject35ApiModel): ProjectApiModel

    /**
    * Create a repository project
    *
    * Creates a repository project board. Returns a &#x60;404 Not Found&#x60; status if projects are disabled in the repository. If you do not have sufficient privileges to perform this action, a &#x60;401 Unauthorized&#x60; or &#x60;410 Gone&#x60; status is returned.
    *
    * @param request 
    * @return ProjectApiModel
    */
    suspend fun projectsCreateForRepo(accessToken: String? = null, repoName: kotlin.String, request: InlineObject116ApiModel): ProjectApiModel

    /**
    * Delete a project
    *
    * Deletes a project board. Returns a &#x60;404 Not Found&#x60; status if projects are disabled.
    *
    * @return void
    */
    suspend fun projectsDelete(accessToken: String? = null, projectId: kotlin.Int)

    /**
    * Delete a project card
    *
    * 
    *
    * @return void
    */
    suspend fun projectsDeleteCard(accessToken: String? = null, cardId: kotlin.Int)

    /**
    * Delete a project column
    *
    * 
    *
    * @return void
    */
    suspend fun projectsDeleteColumn(accessToken: String? = null, columnId: kotlin.Int)

    /**
    * Get a project
    *
    * Gets a project by its &#x60;id&#x60;. Returns a &#x60;404 Not Found&#x60; status if projects are disabled. If you do not have sufficient privileges to perform this action, a &#x60;401 Unauthorized&#x60; or &#x60;410 Gone&#x60; status is returned.
    *
    * @return ProjectApiModel
    */
    suspend fun projectsGet(accessToken: String? = null, projectId: kotlin.Int): ProjectApiModel

    /**
    * Get a project card
    *
    * 
    *
    * @return ProjectMinusCardApiModel
    */
    suspend fun projectsGetCard(accessToken: String? = null, cardId: kotlin.Int): ProjectMinusCardApiModel

    /**
    * Get a project column
    *
    * 
    *
    * @return ProjectMinusColumnApiModel
    */
    suspend fun projectsGetColumn(accessToken: String? = null, columnId: kotlin.Int): ProjectMinusColumnApiModel

    /**
    * Get project permission for a user
    *
    * Returns the collaborator&#39;s permission level for an organization project. Possible values for the &#x60;permission&#x60; key: &#x60;admin&#x60;, &#x60;write&#x60;, &#x60;read&#x60;, &#x60;none&#x60;. You must be an organization owner or a project &#x60;admin&#x60; to review a user&#39;s permission level.
    *
    * @return ProjectMinusCollaboratorMinusPermissionApiModel
    */
    suspend fun projectsGetPermissionForUser(accessToken: String? = null, projectId: kotlin.Int, username: kotlin.String): ProjectMinusCollaboratorMinusPermissionApiModel

    /**
    * List project collaborators
    *
    * Lists the collaborators for an organization project. For a project, the list of collaborators includes outside collaborators, organization members that are direct collaborators, organization members with access through team memberships, organization members with access through default organization permissions, and organization owners. You must be an organization owner or a project &#x60;admin&#x60; to list collaborators.
    *
    * @return kotlin.collections.List<SimpleMinusUserApiModel>
    */
    suspend fun projectsListCollaborators(accessToken: String? = null, projectId: kotlin.Int, affiliation: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<SimpleMinusUserApiModel>

    /**
    * List project columns
    *
    * 
    *
    * @return kotlin.collections.List<ProjectMinusColumnApiModel>
    */
    suspend fun projectsListColumns(accessToken: String? = null, projectId: kotlin.Int, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<ProjectMinusColumnApiModel>

    /**
    * List organization projects
    *
    * Lists the projects in an organization. Returns a &#x60;404 Not Found&#x60; status if projects are disabled in the organization. If you do not have sufficient privileges to perform this action, a &#x60;401 Unauthorized&#x60; or &#x60;410 Gone&#x60; status is returned.
    *
    * @return kotlin.collections.List<ProjectApiModel>
    */
    suspend fun projectsListForOrg(accessToken: String? = null, org: kotlin.String, state: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<ProjectApiModel>

    /**
    * List repository projects
    *
    * Lists the projects in a repository. Returns a &#x60;404 Not Found&#x60; status if projects are disabled in the repository. If you do not have sufficient privileges to perform this action, a &#x60;401 Unauthorized&#x60; or &#x60;410 Gone&#x60; status is returned.
    *
    * @return kotlin.collections.List<ProjectApiModel>
    */
    suspend fun projectsListForRepo(accessToken: String? = null, repoName: kotlin.String, state: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<ProjectApiModel>

    /**
    * List user projects
    *
    * 
    *
    * @return kotlin.collections.List<ProjectApiModel>
    */
    suspend fun projectsListForUser(accessToken: String? = null, username: kotlin.String, state: kotlin.String? = null, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<ProjectApiModel>

    /**
    * Move a project card
    *
    * 
    *
    * @param request 
    * @return kotlin.Any
    */
    suspend fun projectsMoveCard(accessToken: String? = null, cardId: kotlin.Int, request: InlineObject51ApiModel): kotlin.Any

    /**
    * Move a project column
    *
    * 
    *
    * @param request 
    * @return kotlin.Any
    */
    suspend fun projectsMoveColumn(accessToken: String? = null, columnId: kotlin.Int, request: InlineObject53ApiModel): kotlin.Any

    /**
    * Remove user as a collaborator
    *
    * Removes a collaborator from an organization project. You must be an organization owner or a project &#x60;admin&#x60; to remove a collaborator.
    *
    * @return void
    */
    suspend fun projectsRemoveCollaborator(accessToken: String? = null, projectId: kotlin.Int, username: kotlin.String)

    /**
    * Update a project
    *
    * Updates a project board&#39;s information. Returns a &#x60;404 Not Found&#x60; status if projects are disabled. If you do not have sufficient privileges to perform this action, a &#x60;401 Unauthorized&#x60; or &#x60;410 Gone&#x60; status is returned.
    *
    * @param request  (optional)
    * @return ProjectApiModel
    */
    suspend fun projectsUpdate(accessToken: String? = null, projectId: kotlin.Int, request: InlineObject54ApiModel): ProjectApiModel

    /**
    * Update an existing project card
    *
    * 
    *
    * @param request  (optional)
    * @return ProjectMinusCardApiModel
    */
    suspend fun projectsUpdateCard(accessToken: String? = null, cardId: kotlin.Int, request: InlineObject50ApiModel): ProjectMinusCardApiModel

    /**
    * Update an existing project column
    *
    * 
    *
    * @param request 
    * @return ProjectMinusColumnApiModel
    */
    suspend fun projectsUpdateColumn(accessToken: String? = null, columnId: kotlin.Int, request: InlineObject52ApiModel): ProjectMinusColumnApiModel

}

class HttpClientProjectsApi(private val httpClientProvider: HttpClientProvider) : ProjectsApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun projectsAddCollaborator(accessToken: String?, projectId: kotlin.Int, username: kotlin.String, request: InlineObject55ApiModel) {
        val path = "/projects/{project_id}/collaborators/{username}".replace("{"+"project_id"+"}", "$projectId").replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Put
            body = request
        }
    }

    override suspend fun projectsCreateColumn(accessToken: String?, projectId: kotlin.Int, request: InlineObject56ApiModel): ProjectMinusColumnApiModel {
        val path = "/projects/{project_id}/columns".replace("{"+"project_id"+"}", "$projectId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun projectsCreateForAuthenticatedUser(accessToken: String?, request: InlineObject170ApiModel): ProjectApiModel {
        val path = "/user/projects"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun projectsCreateForOrg(accessToken: String?, org: kotlin.String, request: InlineObject35ApiModel): ProjectApiModel {
        val path = "/orgs/{org}/projects".replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun projectsCreateForRepo(accessToken: String?, repoName: kotlin.String, request: InlineObject116ApiModel): ProjectApiModel {
        val path = "/repos/{repo_name}/projects".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun projectsDelete(accessToken: String?, projectId: kotlin.Int) {
        val path = "/projects/{project_id}".replace("{"+"project_id"+"}", "$projectId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun projectsDeleteCard(accessToken: String?, cardId: kotlin.Int) {
        val path = "/projects/columns/cards/{card_id}".replace("{"+"card_id"+"}", "$cardId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun projectsDeleteColumn(accessToken: String?, columnId: kotlin.Int) {
        val path = "/projects/columns/{column_id}".replace("{"+"column_id"+"}", "$columnId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun projectsGet(accessToken: String?, projectId: kotlin.Int): ProjectApiModel {
        val path = "/projects/{project_id}".replace("{"+"project_id"+"}", "$projectId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun projectsGetCard(accessToken: String?, cardId: kotlin.Int): ProjectMinusCardApiModel {
        val path = "/projects/columns/cards/{card_id}".replace("{"+"card_id"+"}", "$cardId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun projectsGetColumn(accessToken: String?, columnId: kotlin.Int): ProjectMinusColumnApiModel {
        val path = "/projects/columns/{column_id}".replace("{"+"column_id"+"}", "$columnId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun projectsGetPermissionForUser(accessToken: String?, projectId: kotlin.Int, username: kotlin.String): ProjectMinusCollaboratorMinusPermissionApiModel {
        val path = "/projects/{project_id}/collaborators/{username}/permission".replace("{"+"project_id"+"}", "$projectId").replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun projectsListCollaborators(accessToken: String?, projectId: kotlin.Int, affiliation: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<SimpleMinusUserApiModel> {
        val path = "/projects/{project_id}/collaborators".replace("{"+"project_id"+"}", "$projectId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("affiliation", affiliation)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun projectsListColumns(accessToken: String?, projectId: kotlin.Int, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<ProjectMinusColumnApiModel> {
        val path = "/projects/{project_id}/columns".replace("{"+"project_id"+"}", "$projectId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun projectsListForOrg(accessToken: String?, org: kotlin.String, state: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<ProjectApiModel> {
        val path = "/orgs/{org}/projects".replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("state", state)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun projectsListForRepo(accessToken: String?, repoName: kotlin.String, state: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<ProjectApiModel> {
        val path = "/repos/{repo_name}/projects".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("state", state)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun projectsListForUser(accessToken: String?, username: kotlin.String, state: kotlin.String?, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<ProjectApiModel> {
        val path = "/users/{username}/projects".replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("state", state)
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun projectsMoveCard(accessToken: String?, cardId: kotlin.Int, request: InlineObject51ApiModel): kotlin.Any {
        val path = "/projects/columns/cards/{card_id}/moves".replace("{"+"card_id"+"}", "$cardId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun projectsMoveColumn(accessToken: String?, columnId: kotlin.Int, request: InlineObject53ApiModel): kotlin.Any {
        val path = "/projects/columns/{column_id}/moves".replace("{"+"column_id"+"}", "$columnId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun projectsRemoveCollaborator(accessToken: String?, projectId: kotlin.Int, username: kotlin.String) {
        val path = "/projects/{project_id}/collaborators/{username}".replace("{"+"project_id"+"}", "$projectId").replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun projectsUpdate(accessToken: String?, projectId: kotlin.Int, request: InlineObject54ApiModel): ProjectApiModel {
        val path = "/projects/{project_id}".replace("{"+"project_id"+"}", "$projectId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

    override suspend fun projectsUpdateCard(accessToken: String?, cardId: kotlin.Int, request: InlineObject50ApiModel): ProjectMinusCardApiModel {
        val path = "/projects/columns/cards/{card_id}".replace("{"+"card_id"+"}", "$cardId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

    override suspend fun projectsUpdateColumn(accessToken: String?, columnId: kotlin.Int, request: InlineObject52ApiModel): ProjectMinusColumnApiModel {
        val path = "/projects/columns/{column_id}".replace("{"+"column_id"+"}", "$columnId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

}
