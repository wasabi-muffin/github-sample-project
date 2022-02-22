plugins {
    id(Dependencies.Plugin.androidLibrary)
    id(Dependencies.Plugin.kotlinAndroid)
}

setupAndroid()

dependencies {
    api(Dependencies.Test.core)
    api(Dependencies.Test.junit)
    api(Dependencies.Test.junitExt)
    api(Dependencies.Test.roboelectric)
    api(Dependencies.Test.coroutines)
    api(Dependencies.Test.turbine)
    api(Dependencies.Test.mockk)
    api(Dependencies.Test.kotest)
}
