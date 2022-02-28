import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.setupTestCoverage() {
    extensions.findByType(com.android.build.api.dsl.CommonExtension::class.java)?.apply {
        testOptions {
            unitTests.all {
                it.extensions.configure(kotlinx.kover.api.KoverTaskExtension::class) {
                    isDisabled = it.name != "testDevDebugUnitTest"
                }
            }
        }
    }
}

fun Project.setupTestCoverageTask() {
    tasks.withType(kotlinx.kover.tasks.KoverMergedTask::class.java) {
        excludes = listOf(
            // Build
            "*.BuildConfig",
            "dagger*",
            "hilt*",
            "*.*Hilt_*",
            "*.*_Hilt*",
            "*.test.*",
            "*.*Module_*Factory*",
            "*.*_Factory*",
            "*.*_MembersInjector*",
            "*.*_ComponentTreeDeps*",
            "*.databinding.*",
            // Modules
            "*.di.*",
            "*.domain.core.*",
            "*.domain.entities.*",
            "*.domain.repositories.*",
            "*.data.models.*",
            "*.data.sources.*",
            "*.remote.core.*",
            "*.remote.models.*",
            "*.remote.apis.*",
            "*.local.core.*",
            "*.local.models.*",
            "*.local.dao.*",
            "*.presentation.*", // TODO: Add Presentation Test Core
            "*.presentation.core.*",
            "*.presentation.statemachine.*",
            "*.presentation.feature.*.contract.*",
            "*.ui.*", // TODO: Add Ui Tests
            "*.ui.primitives.*"
        )
    }
}
