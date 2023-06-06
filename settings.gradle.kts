pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.essential.gg/repository/maven-public")
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net")
    }
    plugins {
        id("gg.essential.multi-version.root") version "0.1.20"
        id("gg.essential.multi-version.api-validation") version "0.1.20"
    }
}

rootProject.buildFileName = "root.gradle.kts"

listOf(
    "1.8.9-forge",
    "1.9.4-forge",
    "1.10.2-forge",
    "1.11.2-forge",
    "1.12.2-forge",
    "1.15.2-forge",
    "1.16.5-forge",
    "1.16.5-fabric",
    "1.17.1-forge",
    "1.17.1-fabric",
    "1.18.2-forge",
    "1.18.2-fabric",
    "1.19.2-forge",
    "1.19.2-fabric",
    "1.19.4-forge",
    "1.19.4-fabric"
).forEach {version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle.kts"
    }
}

