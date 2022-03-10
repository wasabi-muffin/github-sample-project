package io.github.gmvalentino8.github.sample.data.models

/**
 * Release Data Model
 *
 * @property id unique id for this release
 * @property name name for this release
 * @property tag tag used for this release
 * @property description description for this release
 * @property author author who created this release
 * @property createdAt date this release was created
 * @property publishedAt date this release was published
 */
data class ReleaseModel(
    val id: Int,
    val name: String?,
    val tag: String,
    val url: String,
    val isDraft: Boolean,
    val description: String?,
    val author: UserModel?,
    val createdAt: String,
    val publishedAt: String?,
)
