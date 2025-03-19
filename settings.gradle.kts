pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Recipe"
include(":app")
include(":feature:category:presenter")
include(":feature:category:domain")
include(":feature:category:data")
include(":feature:meal:presenter")
include(":feature:meal:domain")
include(":feature:meal:data")
include(":common")
