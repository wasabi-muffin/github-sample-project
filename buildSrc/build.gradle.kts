plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    maven("https://plugins.gradle.org/m2/")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("com.android.tools.build:gradle:7.0.3")
    implementation("org.jetbrains.kotlinx:kover:0.5.0")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.2.1")
}
