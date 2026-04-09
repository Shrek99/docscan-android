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
    }
}

rootProject.name = "docscan-android"
include(
    ":app",
    ":core:common",
    ":core:ui",
    ":core:designsystem",
    ":core:camera",
    ":core:cv",
    ":core:ocr",
    ":core:storage",
    ":core:database",
    ":core:network",
    ":domain",
    ":data",
    ":feature_scan",
    ":feature_review",
    ":feature_documents",
    ":feature_export",
    ":feature_sync",
    ":feature_settings",
)
