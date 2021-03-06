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

package io.github.gmvalentino8.github.sample.remote.models

import io.github.gmvalentino8.github.sample.remote.models.ImportProjectChoicesApiModel

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A repository import from an external source.
 * @param vcs 
 * @param vcsUrl The URL of the originating repository.
 * @param status 
 * @param url 
 * @param htmlUrl 
 * @param authorsUrl 
 * @param repositoryUrl 
 * @param useLfs 
 * @param svcRoot 
 * @param tfvcProject 
 * @param statusText 
 * @param failedStep 
 * @param errorMessage 
 * @param importPercent 
 * @param commitCount 
 * @param pushPercent 
 * @param hasLargeFiles 
 * @param largeFilesSize 
 * @param largeFilesCount 
 * @param projectChoices 
 * @param message 
 * @param authorsCount 
 * @param svnRoot 
 */
@Serializable
data class ImportApiModel(
    @SerialName(value = "vcs")
    val vcs: kotlin.String?,
    /* The URL of the originating repository. */
    @SerialName(value = "vcs_url")
    val vcsUrl: kotlin.String,
    @SerialName(value = "status")
    val status: ImportApiModel.Status,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String,
    @SerialName(value = "authors_url")
    val authorsUrl: kotlin.String,
    @SerialName(value = "repository_url")
    val repositoryUrl: kotlin.String,
    @SerialName(value = "use_lfs")
    val useLfs: kotlin.Boolean? = null,
    @SerialName(value = "svc_root")
    val svcRoot: kotlin.String? = null,
    @SerialName(value = "tfvc_project")
    val tfvcProject: kotlin.String? = null,
    @SerialName(value = "status_text")
    val statusText: kotlin.String? = null,
    @SerialName(value = "failed_step")
    val failedStep: kotlin.String? = null,
    @SerialName(value = "error_message")
    val errorMessage: kotlin.String? = null,
    @SerialName(value = "import_percent")
    val importPercent: kotlin.Int? = null,
    @SerialName(value = "commit_count")
    val commitCount: kotlin.Int? = null,
    @SerialName(value = "push_percent")
    val pushPercent: kotlin.Int? = null,
    @SerialName(value = "has_large_files")
    val hasLargeFiles: kotlin.Boolean? = null,
    @SerialName(value = "large_files_size")
    val largeFilesSize: kotlin.Int? = null,
    @SerialName(value = "large_files_count")
    val largeFilesCount: kotlin.Int? = null,
    @SerialName(value = "project_choices")
    val projectChoices: kotlin.collections.List<ImportProjectChoicesApiModel>? = null,
    @SerialName(value = "message")
    val message: kotlin.String? = null,
    @SerialName(value = "authors_count")
    val authorsCount: kotlin.Int? = null,
    @SerialName(value = "svn_root")
    val svnRoot: kotlin.String? = null
) {

    /**
     * 
     * Values: auth,error,none,detecting,choose,authFailed,importing,mapping,waitingToPush,pushing,complete,setup,unknown,detectionFoundMultiple,detectionFoundNothing,detectionNeedsAuth
     */
    @Serializable(with = Status.Serializer::class)
    enum class Status(val value: kotlin.String) {
        auth("auth"),
        error("error"),
        none("none"),
        detecting("detecting"),
        choose("choose"),
        authFailed("auth_failed"),
        importing("importing"),
        mapping("mapping"),
        waitingToPush("waiting_to_push"),
        pushing("pushing"),
        complete("complete"),
        setup("setup"),
        unknown("unknown"),
        detectionFoundMultiple("detection_found_multiple"),
        detectionFoundNothing("detection_found_nothing"),
        detectionNeedsAuth("detection_needs_auth");

        @kotlinx.serialization.Serializer(forClass = Status::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Status {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "ImportApiModel.Status.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Status) {
                return encoder.encodeString(value.value)
            }
        }
    }
}

