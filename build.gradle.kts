plugins {
    id(Dependencies.Plugin.ktlint) version Versions.ktLint
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
    }
}

ktlint {
    verbose.set(true)
    ignoreFailures.set(true)
    coloredOutput.set(true)
    outputColorName.set("RED")
    additionalEditorconfigFile.set(File("${rootDir.absolutePath}/.editorconfig"))
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
        include("**/*.kts")
    }
}

tasks.register("clean", Delete::class) {
    group = "cleanup"
    delete(rootProject.buildDir)
}
