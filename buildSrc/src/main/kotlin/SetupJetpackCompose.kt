import org.gradle.api.Project

fun Project.setupJetpackCompose() {
    extensions.findByType(com.android.build.api.dsl.CommonExtension::class.java)?.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = Versions.compose
        }
    }
}
