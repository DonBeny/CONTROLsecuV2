pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Pour signature-pad depuis JitPack
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "CONTROLsecuV2"
include(":app")
