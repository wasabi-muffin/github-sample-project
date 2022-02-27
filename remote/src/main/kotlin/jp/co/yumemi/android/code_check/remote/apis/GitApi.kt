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

interface GitApi {
    /**
    * Create a blob
    *
    * 
    *
    * @param request 
    * @return ShortMinusBlobApiModel
    */
    suspend fun gitCreateBlob(accessToken: String? = null, repoName: kotlin.String, request: InlineObject85ApiModel): ShortMinusBlobApiModel

    /**
    * Create a commit
    *
    * Creates a new Git [commit object](https://git-scm.com/book/en/v1/Git-Internals-Git-Objects#Commit-Objects).  **Signature verification object**  The response will include a &#x60;verification&#x60; object that describes the result of verifying the commit&#39;s signature. The following fields are included in the &#x60;verification&#x60; object:  | Name | Type | Description | | ---- | ---- | ----------- | | &#x60;verified&#x60; | &#x60;boolean&#x60; | Indicates whether GitHub considers the signature in this commit to be verified. | | &#x60;reason&#x60; | &#x60;string&#x60; | The reason for verified value. Possible values and their meanings are enumerated in table below. | | &#x60;signature&#x60; | &#x60;string&#x60; | The signature that was extracted from the commit. | | &#x60;payload&#x60; | &#x60;string&#x60; | The value that was signed. |  These are the possible values for &#x60;reason&#x60; in the &#x60;verification&#x60; object:  | Value | Description | | ----- | ----------- | | &#x60;expired_key&#x60; | The key that made the signature is expired. | | &#x60;not_signing_key&#x60; | The \&quot;signing\&quot; flag is not among the usage flags in the GPG key that made the signature. | | &#x60;gpgverify_error&#x60; | There was an error communicating with the signature verification service. | | &#x60;gpgverify_unavailable&#x60; | The signature verification service is currently unavailable. | | &#x60;unsigned&#x60; | The object does not include a signature. | | &#x60;unknown_signature_type&#x60; | A non-PGP signature was found in the commit. | | &#x60;no_user&#x60; | No user was associated with the &#x60;committer&#x60; email address in the commit. | | &#x60;unverified_email&#x60; | The &#x60;committer&#x60; email address in the commit was associated with a user, but the email address is not verified on her/his account. | | &#x60;bad_email&#x60; | The &#x60;committer&#x60; email address in the commit is not included in the identities of the PGP key that made the signature. | | &#x60;unknown_key&#x60; | The key that made the signature has not been registered with any user&#39;s account. | | &#x60;malformed_signature&#x60; | There was an error parsing the signature. | | &#x60;invalid&#x60; | The signature could not be cryptographically verified using the key whose key-id was found in the signature. | | &#x60;valid&#x60; | None of the above errors applied, so the signature is considered to be verified. |
    *
    * @param request 
    * @return GitMinusCommitApiModel
    */
    suspend fun gitCreateCommit(accessToken: String? = null, repoName: kotlin.String, request: InlineObject86ApiModel): GitMinusCommitApiModel

    /**
    * Create a reference
    *
    * Creates a reference for your repository. You are unable to create new references for empty repositories, even if the commit SHA-1 hash used exists. Empty repositories are repositories without branches.
    *
    * @param request 
    * @return GitMinusRefApiModel
    */
    suspend fun gitCreateRef(accessToken: String? = null, repoName: kotlin.String, request: InlineObject87ApiModel): GitMinusRefApiModel

    /**
    * Create a tag object
    *
    * Note that creating a tag object does not create the reference that makes a tag in Git. If you want to create an annotated tag in Git, you have to do this call to create the tag object, and then [create](https://docs.github.com/rest/reference/git#create-a-reference) the &#x60;refs/tags/[tag]&#x60; reference. If you want to create a lightweight tag, you only have to [create](https://docs.github.com/rest/reference/git#create-a-reference) the tag reference - this call would be unnecessary.  **Signature verification object**  The response will include a &#x60;verification&#x60; object that describes the result of verifying the commit&#39;s signature. The following fields are included in the &#x60;verification&#x60; object:  | Name | Type | Description | | ---- | ---- | ----------- | | &#x60;verified&#x60; | &#x60;boolean&#x60; | Indicates whether GitHub considers the signature in this commit to be verified. | | &#x60;reason&#x60; | &#x60;string&#x60; | The reason for verified value. Possible values and their meanings are enumerated in table below. | | &#x60;signature&#x60; | &#x60;string&#x60; | The signature that was extracted from the commit. | | &#x60;payload&#x60; | &#x60;string&#x60; | The value that was signed. |  These are the possible values for &#x60;reason&#x60; in the &#x60;verification&#x60; object:  | Value | Description | | ----- | ----------- | | &#x60;expired_key&#x60; | The key that made the signature is expired. | | &#x60;not_signing_key&#x60; | The \&quot;signing\&quot; flag is not among the usage flags in the GPG key that made the signature. | | &#x60;gpgverify_error&#x60; | There was an error communicating with the signature verification service. | | &#x60;gpgverify_unavailable&#x60; | The signature verification service is currently unavailable. | | &#x60;unsigned&#x60; | The object does not include a signature. | | &#x60;unknown_signature_type&#x60; | A non-PGP signature was found in the commit. | | &#x60;no_user&#x60; | No user was associated with the &#x60;committer&#x60; email address in the commit. | | &#x60;unverified_email&#x60; | The &#x60;committer&#x60; email address in the commit was associated with a user, but the email address is not verified on her/his account. | | &#x60;bad_email&#x60; | The &#x60;committer&#x60; email address in the commit is not included in the identities of the PGP key that made the signature. | | &#x60;unknown_key&#x60; | The key that made the signature has not been registered with any user&#39;s account. | | &#x60;malformed_signature&#x60; | There was an error parsing the signature. | | &#x60;invalid&#x60; | The signature could not be cryptographically verified using the key whose key-id was found in the signature. | | &#x60;valid&#x60; | None of the above errors applied, so the signature is considered to be verified. |
    *
    * @param request 
    * @return GitMinusTagApiModel
    */
    suspend fun gitCreateTag(accessToken: String? = null, repoName: kotlin.String, request: InlineObject89ApiModel): GitMinusTagApiModel

    /**
    * Create a tree
    *
    * The tree creation API accepts nested entries. If you specify both a tree and a nested path modifying that tree, this endpoint will overwrite the contents of the tree with the new path contents, and create a new tree structure.  If you use this endpoint to add, delete, or modify the file contents in a tree, you will need to commit the tree and then update a branch to point to the commit. For more information see \&quot;[Create a commit](https://docs.github.com/rest/reference/git#create-a-commit)\&quot; and \&quot;[Update a reference](https://docs.github.com/rest/reference/git#update-a-reference).\&quot;
    *
    * @param request 
    * @return GitMinusTreeApiModel
    */
    suspend fun gitCreateTree(accessToken: String? = null, repoName: kotlin.String, request: InlineObject90ApiModel): GitMinusTreeApiModel

    /**
    * Delete a reference
    *
    * 
    *
    * @return void
    */
    suspend fun gitDeleteRef(accessToken: String? = null, repoName: kotlin.String, ref: kotlin.String)

    /**
    * Get a blob
    *
    * The &#x60;content&#x60; in the response will always be Base64 encoded.  _Note_: This API supports blobs up to 100 megabytes in size.
    *
    * @return BlobApiModel
    */
    suspend fun gitGetBlob(accessToken: String? = null, repoName: kotlin.String, fileSha: kotlin.String): BlobApiModel

    /**
    * Get a commit
    *
    * Gets a Git [commit object](https://git-scm.com/book/en/v1/Git-Internals-Git-Objects#Commit-Objects).  **Signature verification object**  The response will include a &#x60;verification&#x60; object that describes the result of verifying the commit&#39;s signature. The following fields are included in the &#x60;verification&#x60; object:  | Name | Type | Description | | ---- | ---- | ----------- | | &#x60;verified&#x60; | &#x60;boolean&#x60; | Indicates whether GitHub considers the signature in this commit to be verified. | | &#x60;reason&#x60; | &#x60;string&#x60; | The reason for verified value. Possible values and their meanings are enumerated in table below. | | &#x60;signature&#x60; | &#x60;string&#x60; | The signature that was extracted from the commit. | | &#x60;payload&#x60; | &#x60;string&#x60; | The value that was signed. |  These are the possible values for &#x60;reason&#x60; in the &#x60;verification&#x60; object:  | Value | Description | | ----- | ----------- | | &#x60;expired_key&#x60; | The key that made the signature is expired. | | &#x60;not_signing_key&#x60; | The \&quot;signing\&quot; flag is not among the usage flags in the GPG key that made the signature. | | &#x60;gpgverify_error&#x60; | There was an error communicating with the signature verification service. | | &#x60;gpgverify_unavailable&#x60; | The signature verification service is currently unavailable. | | &#x60;unsigned&#x60; | The object does not include a signature. | | &#x60;unknown_signature_type&#x60; | A non-PGP signature was found in the commit. | | &#x60;no_user&#x60; | No user was associated with the &#x60;committer&#x60; email address in the commit. | | &#x60;unverified_email&#x60; | The &#x60;committer&#x60; email address in the commit was associated with a user, but the email address is not verified on her/his account. | | &#x60;bad_email&#x60; | The &#x60;committer&#x60; email address in the commit is not included in the identities of the PGP key that made the signature. | | &#x60;unknown_key&#x60; | The key that made the signature has not been registered with any user&#39;s account. | | &#x60;malformed_signature&#x60; | There was an error parsing the signature. | | &#x60;invalid&#x60; | The signature could not be cryptographically verified using the key whose key-id was found in the signature. | | &#x60;valid&#x60; | None of the above errors applied, so the signature is considered to be verified. |
    *
    * @return GitMinusCommitApiModel
    */
    suspend fun gitGetCommit(accessToken: String? = null, repoName: kotlin.String, commitSha: kotlin.String): GitMinusCommitApiModel

    /**
    * Get a reference
    *
    * Returns a single reference from your Git database. The &#x60;:ref&#x60; in the URL must be formatted as &#x60;heads/&lt;branch name&gt;&#x60; for branches and &#x60;tags/&lt;tag name&gt;&#x60; for tags. If the &#x60;:ref&#x60; doesn&#39;t match an existing ref, a &#x60;404&#x60; is returned.  **Note:** You need to explicitly [request a pull request](https://docs.github.com/rest/reference/pulls#get-a-pull-request) to trigger a test merge commit, which checks the mergeability of pull requests. For more information, see \&quot;[Checking mergeability of pull requests](https://docs.github.com/rest/guides/getting-started-with-the-git-database-api#checking-mergeability-of-pull-requests)\&quot;.
    *
    * @return GitMinusRefApiModel
    */
    suspend fun gitGetRef(accessToken: String? = null, repoName: kotlin.String, ref: kotlin.String): GitMinusRefApiModel

    /**
    * Get a tag
    *
    * **Signature verification object**  The response will include a &#x60;verification&#x60; object that describes the result of verifying the commit&#39;s signature. The following fields are included in the &#x60;verification&#x60; object:  | Name | Type | Description | | ---- | ---- | ----------- | | &#x60;verified&#x60; | &#x60;boolean&#x60; | Indicates whether GitHub considers the signature in this commit to be verified. | | &#x60;reason&#x60; | &#x60;string&#x60; | The reason for verified value. Possible values and their meanings are enumerated in table below. | | &#x60;signature&#x60; | &#x60;string&#x60; | The signature that was extracted from the commit. | | &#x60;payload&#x60; | &#x60;string&#x60; | The value that was signed. |  These are the possible values for &#x60;reason&#x60; in the &#x60;verification&#x60; object:  | Value | Description | | ----- | ----------- | | &#x60;expired_key&#x60; | The key that made the signature is expired. | | &#x60;not_signing_key&#x60; | The \&quot;signing\&quot; flag is not among the usage flags in the GPG key that made the signature. | | &#x60;gpgverify_error&#x60; | There was an error communicating with the signature verification service. | | &#x60;gpgverify_unavailable&#x60; | The signature verification service is currently unavailable. | | &#x60;unsigned&#x60; | The object does not include a signature. | | &#x60;unknown_signature_type&#x60; | A non-PGP signature was found in the commit. | | &#x60;no_user&#x60; | No user was associated with the &#x60;committer&#x60; email address in the commit. | | &#x60;unverified_email&#x60; | The &#x60;committer&#x60; email address in the commit was associated with a user, but the email address is not verified on her/his account. | | &#x60;bad_email&#x60; | The &#x60;committer&#x60; email address in the commit is not included in the identities of the PGP key that made the signature. | | &#x60;unknown_key&#x60; | The key that made the signature has not been registered with any user&#39;s account. | | &#x60;malformed_signature&#x60; | There was an error parsing the signature. | | &#x60;invalid&#x60; | The signature could not be cryptographically verified using the key whose key-id was found in the signature. | | &#x60;valid&#x60; | None of the above errors applied, so the signature is considered to be verified. |
    *
    * @return GitMinusTagApiModel
    */
    suspend fun gitGetTag(accessToken: String? = null, repoName: kotlin.String, tagSha: kotlin.String): GitMinusTagApiModel

    /**
    * Get a tree
    *
    * Returns a single tree using the SHA1 value for that tree.  If &#x60;truncated&#x60; is &#x60;true&#x60; in the response then the number of items in the &#x60;tree&#x60; array exceeded our maximum limit. If you need to fetch more items, use the non-recursive method of fetching trees, and fetch one sub-tree at a time.
    *
    * @return GitMinusTreeApiModel
    */
    suspend fun gitGetTree(accessToken: String? = null, repoName: kotlin.String, treeSha: kotlin.String, recursive: kotlin.String? = null): GitMinusTreeApiModel

    /**
    * List matching references
    *
    * Returns an array of references from your Git database that match the supplied name. The &#x60;:ref&#x60; in the URL must be formatted as &#x60;heads/&lt;branch name&gt;&#x60; for branches and &#x60;tags/&lt;tag name&gt;&#x60; for tags. If the &#x60;:ref&#x60; doesn&#39;t exist in the repository, but existing refs start with &#x60;:ref&#x60;, they will be returned as an array.  When you use this endpoint without providing a &#x60;:ref&#x60;, it will return an array of all the references from your Git database, including notes and stashes if they exist on the server. Anything in the namespace is returned, not just &#x60;heads&#x60; and &#x60;tags&#x60;.  **Note:** You need to explicitly [request a pull request](https://docs.github.com/rest/reference/pulls#get-a-pull-request) to trigger a test merge commit, which checks the mergeability of pull requests. For more information, see \&quot;[Checking mergeability of pull requests](https://docs.github.com/rest/guides/getting-started-with-the-git-database-api#checking-mergeability-of-pull-requests)\&quot;.  If you request matching references for a branch named &#x60;feature&#x60; but the branch &#x60;feature&#x60; doesn&#39;t exist, the response can still include other matching head refs that start with the word &#x60;feature&#x60;, such as &#x60;featureA&#x60; and &#x60;featureB&#x60;.
    *
    * @return kotlin.collections.List<GitMinusRefApiModel>
    */
    suspend fun gitListMatchingRefs(accessToken: String? = null, repoName: kotlin.String, ref: kotlin.String, perPage: kotlin.Int? = null, page: kotlin.Int? = null): kotlin.collections.List<GitMinusRefApiModel>

    /**
    * Update a reference
    *
    * 
    *
    * @param request 
    * @return GitMinusRefApiModel
    */
    suspend fun gitUpdateRef(accessToken: String? = null, repoName: kotlin.String, ref: kotlin.String, request: InlineObject88ApiModel): GitMinusRefApiModel

}

class HttpClientGitApi(private val httpClientProvider: HttpClientProvider) : GitApi {
    internal val httpClient = httpClientProvider.provide()

    override suspend fun gitCreateBlob(accessToken: String?, repoName: kotlin.String, request: InlineObject85ApiModel): ShortMinusBlobApiModel {
        val path = "/repos/{repo_name}/git/blobs".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun gitCreateCommit(accessToken: String?, repoName: kotlin.String, request: InlineObject86ApiModel): GitMinusCommitApiModel {
        val path = "/repos/{repo_name}/git/commits".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun gitCreateRef(accessToken: String?, repoName: kotlin.String, request: InlineObject87ApiModel): GitMinusRefApiModel {
        val path = "/repos/{repo_name}/git/refs".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun gitCreateTag(accessToken: String?, repoName: kotlin.String, request: InlineObject89ApiModel): GitMinusTagApiModel {
        val path = "/repos/{repo_name}/git/tags".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun gitCreateTree(accessToken: String?, repoName: kotlin.String, request: InlineObject90ApiModel): GitMinusTreeApiModel {
        val path = "/repos/{repo_name}/git/trees".replace("{"+"repo_name"+"}", "$repoName")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Post
            body = request
        }
    }

    override suspend fun gitDeleteRef(accessToken: String?, repoName: kotlin.String, ref: kotlin.String) {
        val path = "/repos/{repo_name}/git/refs/{ref}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"ref"+"}", "$ref")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Delete
        }
    }

    override suspend fun gitGetBlob(accessToken: String?, repoName: kotlin.String, fileSha: kotlin.String): BlobApiModel {
        val path = "/repos/{repo_name}/git/blobs/{file_sha}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"file_sha"+"}", "$fileSha")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun gitGetCommit(accessToken: String?, repoName: kotlin.String, commitSha: kotlin.String): GitMinusCommitApiModel {
        val path = "/repos/{repo_name}/git/commits/{commit_sha}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"commit_sha"+"}", "$commitSha")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun gitGetRef(accessToken: String?, repoName: kotlin.String, ref: kotlin.String): GitMinusRefApiModel {
        val path = "/repos/{repo_name}/git/ref/{ref}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"ref"+"}", "$ref")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun gitGetTag(accessToken: String?, repoName: kotlin.String, tagSha: kotlin.String): GitMinusTagApiModel {
        val path = "/repos/{repo_name}/git/tags/{tag_sha}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"tag_sha"+"}", "$tagSha")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
        }
    }

    override suspend fun gitGetTree(accessToken: String?, repoName: kotlin.String, treeSha: kotlin.String, recursive: kotlin.String?): GitMinusTreeApiModel {
        val path = "/repos/{repo_name}/git/trees/{tree_sha}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"tree_sha"+"}", "$treeSha")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("recursive", recursive)
        }
    }

    override suspend fun gitListMatchingRefs(accessToken: String?, repoName: kotlin.String, ref: kotlin.String, perPage: kotlin.Int?, page: kotlin.Int?): kotlin.collections.List<GitMinusRefApiModel> {
        val path = "/repos/{repo_name}/git/matching-refs/{ref}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"ref"+"}", "$ref")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Get
            parameter("per_page", perPage)
            parameter("page", page)
        }
    }

    override suspend fun gitUpdateRef(accessToken: String?, repoName: kotlin.String, ref: kotlin.String, request: InlineObject88ApiModel): GitMinusRefApiModel {
        val path = "/repos/{repo_name}/git/refs/{ref}".replace("{"+"repo_name"+"}", "$repoName").replace("{"+"ref"+"}", "$ref")

        return httpClient.request {
            url { encodedPath = path }
            method = HttpMethod.Patch
            body = request
        }
    }

}
