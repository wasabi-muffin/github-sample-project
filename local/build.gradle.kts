plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.serialization)
}

setupAndroid()

dependencies {
    project(Modules.Data)
    projectTest(Modules.Test)

    implementation(Dependencies.Kotlinx.serializationJson)
    implementation(Dependencies.Room.runtime)
    annotationProcessor(Dependencies.Room.compiler)
}
