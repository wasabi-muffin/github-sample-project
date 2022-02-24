buildscript {
    val kotlinVersion = "1.6.10"

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
    }

    configurations.classpath.get().resolutionStrategy.eachDependency {
        if (requested.group == "org.jetbrains.kotlin") {
            useVersion(kotlinVersion)
        }
    }
}

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    compileOnly(gradleApi())
    implementation(kotlin("gradle-plugin"))
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("com.android.tools.build:gradle:7.0.3")
    implementation(kotlin("script-runtime"))
}
