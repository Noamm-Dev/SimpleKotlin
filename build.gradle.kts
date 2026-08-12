repositories { mavenCentral() }

plugins {
    kotlin("jvm") version "2.4.10"
    id("com.gradleup.shadow") version "9.6.1"
}

dependencies {
    implementation("ch.qos.logback:logback-classic:1.6.1")
    //implementation("org.noamm:eventbus:1.0.0")
}

tasks.jar { enabled = false }
tasks.shadowJar {
    mergeServiceFiles()
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    manifest { attributes["Main-Class"] = rootProject.name }
    archiveBaseName.set(rootProject.name)
    archiveClassifier.set("")
    archiveVersion.set("")
}

tasks.build.get().dependsOn(tasks.shadowJar)