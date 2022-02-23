plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
    id(Dependencies.Plugin.kotlinKapt)
    id(Dependencies.Plugin.serialization)
}

setupAndroid()

dependencies {
    project(Modules.Data)
    projectTest(Modules.Test)

    implementation(Dependencies.Kotlinx.serializationJson)
    implementation(Dependencies.Kotlinx.datetime)
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.coroutines)
    kapt(Dependencies.Room.compiler)
}
