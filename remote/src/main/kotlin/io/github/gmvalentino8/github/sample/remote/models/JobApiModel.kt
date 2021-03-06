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

import io.github.gmvalentino8.github.sample.remote.models.JobStepsApiModel

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Information of a job execution in a workflow run
 * @param id The id of the job.
 * @param runId The id of the associated workflow run.
 * @param runUrl 
 * @param nodeId 
 * @param headSha The SHA of the commit that is being run.
 * @param url 
 * @param htmlUrl 
 * @param status The phase of the lifecycle that the job is currently in.
 * @param conclusion The outcome of the job.
 * @param startedAt The time that the job started, in ISO 8601 format.
 * @param completedAt The time that the job finished, in ISO 8601 format.
 * @param name The name of the job.
 * @param checkRunUrl 
 * @param labels Labels for the workflow job. Specified by the \"runs_on\" attribute in the action's workflow file.
 * @param runnerId The ID of the runner to which this job has been assigned. (If a runner hasn't yet been assigned, this will be null.)
 * @param runnerName The name of the runner to which this job has been assigned. (If a runner hasn't yet been assigned, this will be null.)
 * @param runnerGroupId The ID of the runner group to which this job has been assigned. (If a runner hasn't yet been assigned, this will be null.)
 * @param runnerGroupName The name of the runner group to which this job has been assigned. (If a runner hasn't yet been assigned, this will be null.)
 * @param runAttempt Attempt number of the associated workflow run, 1 for first attempt and higher if the workflow was re-run.
 * @param steps Steps in this job.
 */
@Serializable
data class JobApiModel(
    /* The id of the job. */
    @SerialName(value = "id")
    val id: kotlin.Int,
    /* The id of the associated workflow run. */
    @SerialName(value = "run_id")
    val runId: kotlin.Int,
    @SerialName(value = "run_url")
    val runUrl: kotlin.String,
    @SerialName(value = "node_id")
    val nodeId: kotlin.String,
    /* The SHA of the commit that is being run. */
    @SerialName(value = "head_sha")
    val headSha: kotlin.String,
    @SerialName(value = "url")
    val url: kotlin.String,
    @SerialName(value = "html_url")
    val htmlUrl: kotlin.String?,
    /* The phase of the lifecycle that the job is currently in. */
    @SerialName(value = "status")
    val status: JobApiModel.Status,
    /* The outcome of the job. */
    @SerialName(value = "conclusion")
    val conclusion: kotlin.String?,
    /* The time that the job started, in ISO 8601 format. */
    @SerialName(value = "started_at")
    val startedAt: kotlin.String,
    /* The time that the job finished, in ISO 8601 format. */
    @SerialName(value = "completed_at")
    val completedAt: kotlin.String?,
    /* The name of the job. */
    @SerialName(value = "name")
    val name: kotlin.String,
    @SerialName(value = "check_run_url")
    val checkRunUrl: kotlin.String,
    /* Labels for the workflow job. Specified by the \"runs_on\" attribute in the action's workflow file. */
    @SerialName(value = "labels")
    val labels: kotlin.collections.List<kotlin.String>,
    /* The ID of the runner to which this job has been assigned. (If a runner hasn't yet been assigned, this will be null.) */
    @SerialName(value = "runner_id")
    val runnerId: kotlin.Int?,
    /* The name of the runner to which this job has been assigned. (If a runner hasn't yet been assigned, this will be null.) */
    @SerialName(value = "runner_name")
    val runnerName: kotlin.String?,
    /* The ID of the runner group to which this job has been assigned. (If a runner hasn't yet been assigned, this will be null.) */
    @SerialName(value = "runner_group_id")
    val runnerGroupId: kotlin.Int?,
    /* The name of the runner group to which this job has been assigned. (If a runner hasn't yet been assigned, this will be null.) */
    @SerialName(value = "runner_group_name")
    val runnerGroupName: kotlin.String?,
    /* Attempt number of the associated workflow run, 1 for first attempt and higher if the workflow was re-run. */
    @SerialName(value = "run_attempt")
    val runAttempt: kotlin.Int? = null,
    /* Steps in this job. */
    @SerialName(value = "steps")
    val steps: kotlin.collections.List<JobStepsApiModel>? = null
) {

    /**
     * The phase of the lifecycle that the job is currently in.
     * Values: queued,inProgress,completed
     */
    @Serializable(with = Status.Serializer::class)
    enum class Status(val value: kotlin.String) {
        queued("queued"),
        inProgress("in_progress"),
        completed("completed");

        @kotlinx.serialization.Serializer(forClass = Status::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Status {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "JobApiModel.Status.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Status) {
                return encoder.encodeString(value.value)
            }
        }
    }
}

