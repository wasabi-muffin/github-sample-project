rootProject.name = "Android Engineer CodeCheck"

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")
include(":domain")
include(":data")
include(":remote")
include(":local")
include(":test-internal")
