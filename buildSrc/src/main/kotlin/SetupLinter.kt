import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import java.io.File
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

fun Project.setupLinter() {
    plugins.apply(Dependencies.Plugin.ktlint)

    extensions.findByType(org.jlleitschuh.gradle.ktlint.KtlintExtension::class.java)?.apply {
        verbose.set(true)
        android.set(true)
        ignoreFailures.set(true)
        coloredOutput.set(true)
        outputColorName.set("RED")
        additionalEditorconfigFile.set(File("${rootDir.path}/.editorconfig"))
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
        }
        filter {
            include("**/kotlin/**")
            include("*.kts")
            exclude("**/generated/**")
            exclude("**/remote/models/**")
            exclude("**/remote/apis/**")
        }
    }
}
