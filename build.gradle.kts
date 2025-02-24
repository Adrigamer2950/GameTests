import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    kotlin("jvm") version "2.1.10"
    alias(libs.plugins.shadow)
    alias(libs.plugins.plugin.yml)
}

group = "me.adrigamer2950"
version = "0.0.1-BETA"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
    maven("https://repo.devadri.es/repository/releases") {
        name = "devadri"
    }
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib-jdk8"))

    // Jetbrains Annotations
    compileOnly(libs.jetbrains.annotations)

    // Paper API
    compileOnly(libs.paper.api)

    // AdriAPI
    compileOnly(libs.adriapi)
}

val targetJavaVersion = 17
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("paper-plugin.yml") {
        expand(props)
    }
}

paper {
    name = rootProject.name
    main = "me.adrigamer2950.gametests.GameTestsPlugin"
    apiVersion = "1.18"
    author = "devadri"
    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
    foliaSupported = true
    website = "https://github.com/Adrigamer2950/GameTests"
    description = "The GameTest Framework brought to Paper"
}
