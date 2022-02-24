import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.setupJetpackCompose() {
    extensions.findByType(BaseAppModuleExtension::class.java)?.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = Versions.compose
        }
    }

    extensions.findByType(LibraryExtension::class.java)?.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = Versions.compose
        }
    }
}
