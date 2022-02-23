import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

enum class Modules(val path: String) {
    Test(":test-internal"),
    Domain(":domain"),
    Data(":data"),
}

fun DependencyHandlerScope.project(module: Modules): Dependency? = "implementation"(project(module.path))
fun DependencyHandlerScope.projectApi(module: Modules): Dependency? = "api"(project(module.path))
fun DependencyHandlerScope.projectTest(module: Modules): Dependency? = "testImplementation"(project(module.path))
