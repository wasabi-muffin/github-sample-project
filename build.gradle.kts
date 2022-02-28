plugins {
    id(Dependencies.Plugin.dokka) version Versions.dokka
    id(Dependencies.Plugin.kover)
    id(Dependencies.Plugin.ktlint)
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
        classpath(Dependencies.Gradle.hilt)
    }
}

setupTestCoverageTask()

tasks.register("clean", Delete::class) {
    group = "cleanup"
    delete(rootProject.buildDir)
}
