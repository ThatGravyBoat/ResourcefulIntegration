plugins {
    id("java")
    id("gg.essential.multi-version")
    id("gg.essential.defaults")
}

group = "com.teamresourceful.resourcefulintegration"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://repo.essential.gg/repository/maven-public/")
    mavenCentral()
}