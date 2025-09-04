plugins {
    id("java")                                 // Java toolchain + bytecode tasks
    kotlin("jvm") version "1.9.22"             // You’re writing Kotlin
    id("org.jetbrains.intellij") version "1.17.3" // Adds runIde, buildPlugin, etc.
}

group = "com.example"                        // Used in artifact coords and ZIP name
version = "1.0.0"                            // Your plugin version (Marketplace uses this)

repositories { mavenCentral() }              // Where 3rd-party libs come from

intellij {
    // Pick the IntelliJ Platform to run against (one of these TWO styles)
    version.set("2024.1")                      // Download this IDE & run against it
    type.set("IC")                              // IC=Community, IU=Ultimate
    // OR: localPath.set("/Applications/IntelliJ IDEA CE.app") // Use your installed IDE

    plugins.set(listOf(/* "java", "Kotlin", etc if you need platform plugins */))
}

kotlin { jvmToolchain(17) }                  // Ensure Java 17 matches JetBrains Runtime

tasks {
    // Auto-patches plugin.xml at build time (keeps metadata in one place)
    patchPluginXml {
        sinceBuild.set("241")                    // 241 = 2024.1 line
        untilBuild.set(null as String?)          // Leave open unless you need a cap
        // Optional: changeNotes.set(file("CHANGELOG.md").readText())
        // Optional: pluginDescription.set(file("README.md").readText())
    }

    // Optional speed-up for local dev
    buildSearchableOptions { enabled = false }

    // Optional tuning for the sandbox IDE process
    // runIde { jvmArgs("-Xmx2g"); args = listOf(/* IDE flags */) }
}

dependencies {
    // Add your own libraries here (they’ll be bundled into your plugin JAR)
    // implementation("com.squareup.moshi:moshi:1.15.1")
    // testImplementation(kotlin("test"))
}
