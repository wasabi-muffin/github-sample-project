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

interface PackagesApi {
    /**
    * Delete a package for the authenticated user
    *
    * Deletes a package owned by the authenticated user. You cannot delete a public package if any version of the package has more than 5,000 downloads. In this scenario, contact GitHub support for further assistance.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:delete&#x60; scopes. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return void
    */
    suspend fun packagesDeletePackageForAuthenticatedUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String)

    /**
    * Delete a package for an organization
    *
    * Deletes an entire package in an organization. You cannot delete a public package if any version of the package has more than 5,000 downloads. In this scenario, contact GitHub support for further assistance.  To use this endpoint, you must have admin permissions in the organization and authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:delete&#x60; scopes. In addition: - If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope. - If &#x60;package_type&#x60; is &#x60;container&#x60;, you must also have admin permissions to the container you want to delete.
    *
    * @return void
    */
    suspend fun packagesDeletePackageForOrg(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String)

    /**
    * Delete a package for a user
    *
    * Deletes an entire package for a user. You cannot delete a public package if any version of the package has more than 5,000 downloads. In this scenario, contact GitHub support for further assistance.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:delete&#x60; scopes. In addition: - If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope. - If &#x60;package_type&#x60; is &#x60;container&#x60;, you must also have admin permissions to the container you want to delete.
    *
    * @return void
    */
    suspend fun packagesDeletePackageForUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String)

    /**
    * Delete a package version for the authenticated user
    *
    * Deletes a specific package version for a package owned by the authenticated user.  If the package is public and the package version has more than 5,000 downloads, you cannot delete the package version. In this scenario, contact GitHub support for further assistance.  To use this endpoint, you must have admin permissions in the organization and authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:delete&#x60; scopes. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return void
    */
    suspend fun packagesDeletePackageVersionForAuthenticatedUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, packageVersionId: kotlin.Int)

    /**
    * Delete package version for an organization
    *
    * Deletes a specific package version in an organization. If the package is public and the package version has more than 5,000 downloads, you cannot delete the package version. In this scenario, contact GitHub support for further assistance.  To use this endpoint, you must have admin permissions in the organization and authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:delete&#x60; scopes. In addition: - If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope. - If &#x60;package_type&#x60; is &#x60;container&#x60;, you must also have admin permissions to the container you want to delete.
    *
    * @return void
    */
    suspend fun packagesDeletePackageVersionForOrg(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, packageVersionId: kotlin.Int)

    /**
    * Delete package version for a user
    *
    * Deletes a specific package version for a user. If the package is public and the package version has more than 5,000 downloads, you cannot delete the package version. In this scenario, contact GitHub support for further assistance.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:delete&#x60; scopes. In addition: - If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope. - If &#x60;package_type&#x60; is &#x60;container&#x60;, you must also have admin permissions to the container you want to delete.
    *
    * @return void
    */
    suspend fun packagesDeletePackageVersionForUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String, packageVersionId: kotlin.Int)

    /**
    * Get all package versions for a package owned by the authenticated user
    *
    * Returns all package versions for a package owned by the authenticated user.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return kotlin.collections.List<PackageMinusVersionApiModel>
    */
    suspend fun packagesGetAllPackageVersionsForPackageOwnedByAuthenticatedUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, page: kotlin.Int? = null, perPage: kotlin.Int? = null, state: kotlin.String? = null): kotlin.collections.List<PackageMinusVersionApiModel>

    /**
    * Get all package versions for a package owned by an organization
    *
    * Returns all package versions for a package owned by an organization.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return kotlin.collections.List<PackageMinusVersionApiModel>
    */
    suspend fun packagesGetAllPackageVersionsForPackageOwnedByOrg(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, page: kotlin.Int? = null, perPage: kotlin.Int? = null, state: kotlin.String? = null): kotlin.collections.List<PackageMinusVersionApiModel>

    /**
    * Get all package versions for a package owned by a user
    *
    * Returns all package versions for a public package owned by a specified user.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return kotlin.collections.List<PackageMinusVersionApiModel>
    */
    suspend fun packagesGetAllPackageVersionsForPackageOwnedByUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String): kotlin.collections.List<PackageMinusVersionApiModel>

    /**
    * Get a package for the authenticated user
    *
    * Gets a specific package for a package owned by the authenticated user.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return PackageApiModel
    */
    suspend fun packagesGetPackageForAuthenticatedUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String): PackageApiModel

    /**
    * Get a package for an organization
    *
    * Gets a specific package in an organization.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return PackageApiModel
    */
    suspend fun packagesGetPackageForOrganization(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String): PackageApiModel

    /**
    * Get a package for a user
    *
    * Gets a specific package metadata for a public package owned by a user.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return PackageApiModel
    */
    suspend fun packagesGetPackageForUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String): PackageApiModel

    /**
    * Get a package version for the authenticated user
    *
    * Gets a specific package version for a package owned by the authenticated user.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return PackageMinusVersionApiModel
    */
    suspend fun packagesGetPackageVersionForAuthenticatedUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, packageVersionId: kotlin.Int): PackageMinusVersionApiModel

    /**
    * Get a package version for an organization
    *
    * Gets a specific package version in an organization.  You must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return PackageMinusVersionApiModel
    */
    suspend fun packagesGetPackageVersionForOrganization(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, packageVersionId: kotlin.Int): PackageMinusVersionApiModel

    /**
    * Get a package version for a user
    *
    * Gets a specific package version for a public package owned by a specified user.  At this time, to use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return PackageMinusVersionApiModel
    */
    suspend fun packagesGetPackageVersionForUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, packageVersionId: kotlin.Int, username: kotlin.String): PackageMinusVersionApiModel

    /**
    * List packages for the authenticated user&#39;s namespace
    *
    * Lists packages owned by the authenticated user within the user&#39;s namespace.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return kotlin.collections.List<PackageApiModel>
    */
    suspend fun packagesListPackagesForAuthenticatedUser(accessToken: String? = null, packageType: kotlin.String? = null, visibility: kotlin.String? = null): kotlin.collections.List<PackageApiModel>

    /**
    * List packages for an organization
    *
    * Lists all packages in an organization readable by the user.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return kotlin.collections.List<PackageApiModel>
    */
    suspend fun packagesListPackagesForOrganization(accessToken: String? = null, org: kotlin.String, packageType: kotlin.String? = null, visibility: kotlin.String? = null): kotlin.collections.List<PackageApiModel>

    /**
    * List packages for a user
    *
    * Lists all packages in a user&#39;s namespace for which the requesting user has access.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; scope. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return kotlin.collections.List<PackageApiModel>
    */
    suspend fun packagesListPackagesForUser(accessToken: String? = null, username: kotlin.String, packageType: kotlin.String? = null, visibility: kotlin.String? = null): kotlin.collections.List<PackageApiModel>

    /**
    * Restore a package for the authenticated user
    *
    * Restores a package owned by the authenticated user.  You can restore a deleted package under the following conditions:   - The package was deleted within the last 30 days.   - The same package namespace and version is still available and not reused for a new package. If the same package namespace is not available, you will not be able to restore your package. In this scenario, to restore the deleted package, you must delete the new package that uses the deleted package&#39;s namespace first.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:write&#x60; scopes. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return void
    */
    suspend fun packagesRestorePackageForAuthenticatedUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, token: kotlin.String? = null)

    /**
    * Restore a package for an organization
    *
    * Restores an entire package in an organization.  You can restore a deleted package under the following conditions:   - The package was deleted within the last 30 days.   - The same package namespace and version is still available and not reused for a new package. If the same package namespace is not available, you will not be able to restore your package. In this scenario, to restore the deleted package, you must delete the new package that uses the deleted package&#39;s namespace first.  To use this endpoint, you must have admin permissions in the organization and authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:write&#x60; scopes. In addition: - If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope. - If &#x60;package_type&#x60; is &#x60;container&#x60;, you must also have admin permissions to the container that you want to restore.
    *
    * @return void
    */
    suspend fun packagesRestorePackageForOrg(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, token: kotlin.String? = null)

    /**
    * Restore a package for a user
    *
    * Restores an entire package for a user.  You can restore a deleted package under the following conditions:   - The package was deleted within the last 30 days.   - The same package namespace and version is still available and not reused for a new package. If the same package namespace is not available, you will not be able to restore your package. In this scenario, to restore the deleted package, you must delete the new package that uses the deleted package&#39;s namespace first.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:write&#x60; scopes. In addition: - If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope. - If &#x60;package_type&#x60; is &#x60;container&#x60;, you must also have admin permissions to the container that you want to restore.
    *
    * @return void
    */
    suspend fun packagesRestorePackageForUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String, token: kotlin.String? = null)

    /**
    * Restore a package version for the authenticated user
    *
    * Restores a package version owned by the authenticated user.  You can restore a deleted package version under the following conditions:   - The package was deleted within the last 30 days.   - The same package namespace and version is still available and not reused for a new package. If the same package namespace is not available, you will not be able to restore your package. In this scenario, to restore the deleted package, you must delete the new package that uses the deleted package&#39;s namespace first.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:write&#x60; scopes. If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope.
    *
    * @return void
    */
    suspend fun packagesRestorePackageVersionForAuthenticatedUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, packageVersionId: kotlin.Int)

    /**
    * Restore package version for an organization
    *
    * Restores a specific package version in an organization.  You can restore a deleted package under the following conditions:   - The package was deleted within the last 30 days.   - The same package namespace and version is still available and not reused for a new package. If the same package namespace is not available, you will not be able to restore your package. In this scenario, to restore the deleted package, you must delete the new package that uses the deleted package&#39;s namespace first.  To use this endpoint, you must have admin permissions in the organization and authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:write&#x60; scopes. In addition: - If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope. - If &#x60;package_type&#x60; is &#x60;container&#x60;, you must also have admin permissions to the container that you want to restore.
    *
    * @return void
    */
    suspend fun packagesRestorePackageVersionForOrg(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, packageVersionId: kotlin.Int)

    /**
    * Restore package version for a user
    *
    * Restores a specific package version for a user.  You can restore a deleted package under the following conditions:   - The package was deleted within the last 30 days.   - The same package namespace and version is still available and not reused for a new package. If the same package namespace is not available, you will not be able to restore your package. In this scenario, to restore the deleted package, you must delete the new package that uses the deleted package&#39;s namespace first.  To use this endpoint, you must authenticate using an access token with the &#x60;packages:read&#x60; and &#x60;packages:write&#x60; scopes. In addition: - If &#x60;package_type&#x60; is not &#x60;container&#x60;, your token must also include the &#x60;repo&#x60; scope. - If &#x60;package_type&#x60; is &#x60;container&#x60;, you must also have admin permissions to the container that you want to restore.
    *
    * @return void
    */
    suspend fun packagesRestorePackageVersionForUser(accessToken: String? = null, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String, packageVersionId: kotlin.Int)

}

class HttpClientPackagesApi(private val httpClientProvider: HttpClientProvider) : PackagesApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun packagesDeletePackageForAuthenticatedUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String) {
        val path = "/user/packages/{package_type}/{package_name}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun packagesDeletePackageForOrg(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String) {
        val path = "/orgs/{org}/packages/{package_type}/{package_name}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun packagesDeletePackageForUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String) {
        val path = "/users/{username}/packages/{package_type}/{package_name}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun packagesDeletePackageVersionForAuthenticatedUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, packageVersionId: kotlin.Int) {
        val path = "/user/packages/{package_type}/{package_name}/versions/{package_version_id}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"package_version_id"+"}", "$packageVersionId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun packagesDeletePackageVersionForOrg(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, packageVersionId: kotlin.Int) {
        val path = "/orgs/{org}/packages/{package_type}/{package_name}/versions/{package_version_id}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"org"+"}", "$org").replace("{"+"package_version_id"+"}", "$packageVersionId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun packagesDeletePackageVersionForUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String, packageVersionId: kotlin.Int) {
        val path = "/users/{username}/packages/{package_type}/{package_name}/versions/{package_version_id}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"username"+"}", "$username").replace("{"+"package_version_id"+"}", "$packageVersionId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun packagesGetAllPackageVersionsForPackageOwnedByAuthenticatedUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, page: kotlin.Int?, perPage: kotlin.Int?, state: kotlin.String?): kotlin.collections.List<PackageMinusVersionApiModel> {
        val path = "/user/packages/{package_type}/{package_name}/versions".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("page", page)
            parameter("perPage", perPage)
            parameter("state", state)
        }
    }

    override suspend fun packagesGetAllPackageVersionsForPackageOwnedByOrg(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, page: kotlin.Int?, perPage: kotlin.Int?, state: kotlin.String?): kotlin.collections.List<PackageMinusVersionApiModel> {
        val path = "/orgs/{org}/packages/{package_type}/{package_name}/versions".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("page", page)
            parameter("perPage", perPage)
            parameter("state", state)
        }
    }

    override suspend fun packagesGetAllPackageVersionsForPackageOwnedByUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String): kotlin.collections.List<PackageMinusVersionApiModel> {
        val path = "/users/{username}/packages/{package_type}/{package_name}/versions".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun packagesGetPackageForAuthenticatedUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String): PackageApiModel {
        val path = "/user/packages/{package_type}/{package_name}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun packagesGetPackageForOrganization(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String): PackageApiModel {
        val path = "/orgs/{org}/packages/{package_type}/{package_name}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun packagesGetPackageForUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String): PackageApiModel {
        val path = "/users/{username}/packages/{package_type}/{package_name}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun packagesGetPackageVersionForAuthenticatedUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, packageVersionId: kotlin.Int): PackageMinusVersionApiModel {
        val path = "/user/packages/{package_type}/{package_name}/versions/{package_version_id}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"package_version_id"+"}", "$packageVersionId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun packagesGetPackageVersionForOrganization(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, packageVersionId: kotlin.Int): PackageMinusVersionApiModel {
        val path = "/orgs/{org}/packages/{package_type}/{package_name}/versions/{package_version_id}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"org"+"}", "$org").replace("{"+"package_version_id"+"}", "$packageVersionId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun packagesGetPackageVersionForUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, packageVersionId: kotlin.Int, username: kotlin.String): PackageMinusVersionApiModel {
        val path = "/users/{username}/packages/{package_type}/{package_name}/versions/{package_version_id}".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"package_version_id"+"}", "$packageVersionId").replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun packagesListPackagesForAuthenticatedUser(accessToken: String?, packageType: kotlin.String?, visibility: kotlin.String?): kotlin.collections.List<PackageApiModel> {
        val path = "/user/packages"

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("packageType", packageType)
            parameter("visibility", visibility)
        }
    }

    override suspend fun packagesListPackagesForOrganization(accessToken: String?, org: kotlin.String, packageType: kotlin.String?, visibility: kotlin.String?): kotlin.collections.List<PackageApiModel> {
        val path = "/orgs/{org}/packages".replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("packageType", packageType)
            parameter("visibility", visibility)
        }
    }

    override suspend fun packagesListPackagesForUser(accessToken: String?, username: kotlin.String, packageType: kotlin.String?, visibility: kotlin.String?): kotlin.collections.List<PackageApiModel> {
        val path = "/users/{username}/packages".replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("packageType", packageType)
            parameter("visibility", visibility)
        }
    }

    override suspend fun packagesRestorePackageForAuthenticatedUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, token: kotlin.String?) {
        val path = "/user/packages/{package_type}/{package_name}/restore".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            parameter("token", token)
        }
    }

    override suspend fun packagesRestorePackageForOrg(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, token: kotlin.String?) {
        val path = "/orgs/{org}/packages/{package_type}/{package_name}/restore".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"org"+"}", "$org")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            parameter("token", token)
        }
    }

    override suspend fun packagesRestorePackageForUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String, token: kotlin.String?) {
        val path = "/users/{username}/packages/{package_type}/{package_name}/restore".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"username"+"}", "$username")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            parameter("token", token)
        }
    }

    override suspend fun packagesRestorePackageVersionForAuthenticatedUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, packageVersionId: kotlin.Int) {
        val path = "/user/packages/{package_type}/{package_name}/versions/{package_version_id}/restore".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"package_version_id"+"}", "$packageVersionId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
        }
    }

    override suspend fun packagesRestorePackageVersionForOrg(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, org: kotlin.String, packageVersionId: kotlin.Int) {
        val path = "/orgs/{org}/packages/{package_type}/{package_name}/versions/{package_version_id}/restore".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"org"+"}", "$org").replace("{"+"package_version_id"+"}", "$packageVersionId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
        }
    }

    override suspend fun packagesRestorePackageVersionForUser(accessToken: String?, packageType: kotlin.String, packageName: kotlin.String, username: kotlin.String, packageVersionId: kotlin.Int) {
        val path = "/users/{username}/packages/{package_type}/{package_name}/versions/{package_version_id}/restore".replace("{"+"package_type"+"}", "$packageType").replace("{"+"package_name"+"}", "$packageName").replace("{"+"username"+"}", "$username").replace("{"+"package_version_id"+"}", "$packageVersionId")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
        }
    }

}
