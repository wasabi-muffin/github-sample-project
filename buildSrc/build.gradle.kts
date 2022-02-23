buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(kotlin("gradle-plugin", "1.5.31"))
    }
}

plugins {
    `kotlin-dsl`
    id("org.jetbrains.kotlinx.kover") version "0.5.0"
}

repositories {
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    implementation("com.android.tools.build:gradle:7.0.3")
    implementation(kotlin("script-runtime"))
}
