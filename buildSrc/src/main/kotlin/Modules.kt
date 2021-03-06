import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

enum class Modules(val path: String) {
    Test(":test-internal"),
    Ui(":ui"),
    Presentation(":presentation"),
    Domain(":domain"),
    Data(":data"),
    Remote(":remote"),
    Local(":local"),
}

fun DependencyHandlerScope.project(module: Modules): Dependency? = "implementation"(project(module.path))
fun DependencyHandlerScope.projectApi(module: Modules): Dependency? = "api"(project(module.path))
fun DependencyHandlerScope.projectTest(module: Modules): Dependency? = "testImplementation"(project(module.path))
