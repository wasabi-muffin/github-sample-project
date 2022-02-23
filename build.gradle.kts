plugins {
    id(Dependencies.Plugin.ktlint) version Versions.ktLint
    id(Dependencies.Plugin.kover) version Versions.kover
    id(Dependencies.Plugin.dokka) version Versions.dokka
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.Gradle.android)
        classpath(Dependencies.Gradle.kotlin)
        classpath(Dependencies.Gradle.safeArgs)
        classpath(Dependencies.Gradle.serialization)
        classpath(Dependencies.Gradle.ktlint)
    }
}

allprojects {
    plugins.apply(Dependencies.Plugin.dokka)
    plugins.apply(Dependencies.Plugin.ktlint)

    ktlint {
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

tasks.withType(kotlinx.kover.tasks.KoverMergedTask::class) {
    excludes = listOf(
        "*.BuildConfig",
        "*.databinding.*",
        "*.test.*",
        "*.domain.core.*",
        "*.domain.entity.*",
        "*.data.models.*",
        "*.remote.core.*",
        "*.remote.models.*",
        "*.remote.apis.*",
        "*.local.core.*",
        "*.local.models.*",
        "*.local.dao.*"
    )
}

tasks.register("clean", Delete::class) {
    group = "cleanup"
    delete(rootProject.buildDir)
}
