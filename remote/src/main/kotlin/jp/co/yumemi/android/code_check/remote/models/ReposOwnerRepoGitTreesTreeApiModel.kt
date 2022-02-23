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

package jp.co.yumemi.android.code_check.remote.models


import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * 
 * @param path The file referenced in the tree.
 * @param mode The file mode; one of `100644` for file (blob), `100755` for executable (blob), `040000` for subdirectory (tree), `160000` for submodule (commit), or `120000` for a blob that specifies the path of a symlink.
 * @param type Either `blob`, `tree`, or `commit`.
 * @param sha The SHA1 checksum ID of the object in the tree. Also called `tree.sha`. If the value is `null` then the file will be deleted.      **Note:** Use either `tree.sha` or `content` to specify the contents of the entry. Using both `tree.sha` and `content` will return an error.
 * @param content The content you want this file to have. GitHub will write this blob out and use that SHA for this entry. Use either this, or `tree.sha`.      **Note:** Use either `tree.sha` or `content` to specify the contents of the entry. Using both `tree.sha` and `content` will return an error.
 */
@Serializable
data class ReposOwnerRepoGitTreesTreeApiModel(
    /* The file referenced in the tree. */
    @SerialName(value = "path")
    val path: kotlin.String? = null,
    /* The file mode; one of `100644` for file (blob), `100755` for executable (blob), `040000` for subdirectory (tree), `160000` for submodule (commit), or `120000` for a blob that specifies the path of a symlink. */
    @SerialName(value = "mode")
    val mode: ReposOwnerRepoGitTreesTreeApiModel.Mode? = null,
    /* Either `blob`, `tree`, or `commit`. */
    @SerialName(value = "type")
    val type: ReposOwnerRepoGitTreesTreeApiModel.Type? = null,
    /* The SHA1 checksum ID of the object in the tree. Also called `tree.sha`. If the value is `null` then the file will be deleted.      **Note:** Use either `tree.sha` or `content` to specify the contents of the entry. Using both `tree.sha` and `content` will return an error. */
    @SerialName(value = "sha")
    val sha: kotlin.String? = null,
    /* The content you want this file to have. GitHub will write this blob out and use that SHA for this entry. Use either this, or `tree.sha`.      **Note:** Use either `tree.sha` or `content` to specify the contents of the entry. Using both `tree.sha` and `content` will return an error. */
    @SerialName(value = "content")
    val content: kotlin.String? = null
) {

    /**
     * The file mode; one of `100644` for file (blob), `100755` for executable (blob), `040000` for subdirectory (tree), `160000` for submodule (commit), or `120000` for a blob that specifies the path of a symlink.
     * Values: _100644,_100755,_040000,_160000,_120000
     */
    @Serializable(with = Mode.Serializer::class)
    enum class Mode(val value: kotlin.String) {
        _100644("100644"),
        _100755("100755"),
        _040000("040000"),
        _160000("160000"),
        _120000("120000");

        @kotlinx.serialization.Serializer(forClass = Mode::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Mode {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "ReposOwnerRepoGitTreesTreeApiModel.Mode.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Mode) {
                return encoder.encodeString(value.value)
            }
        }
    }
    /**
     * Either `blob`, `tree`, or `commit`.
     * Values: blob,tree,commit
     */
    @Serializable(with = Type.Serializer::class)
    enum class Type(val value: kotlin.String) {
        blob("blob"),
        tree("tree"),
        commit("commit");

        @kotlinx.serialization.Serializer(forClass = Type::class)
        object Serializer {
            override fun deserialize(decoder: Decoder): Type {
                val decoded = decoder.decodeString()
                return values().first { it.value == decoded }
            }

            override val descriptor: SerialDescriptor
                get() = PrimitiveSerialDescriptor(
                    "ReposOwnerRepoGitTreesTreeApiModel.Type.Serializer",
                    PrimitiveKind.STRING
                )

            override fun serialize(encoder: Encoder, value: Type) {
                return encoder.encodeString(value.value)
            }
        }
    }
}
