repositories { mavenCentral() }

plugins {
    kotlin("jvm") version "2.4.21"
    id("com.gradleup.shadow") version "9.6.1"
    id("org.graalvm.buildtools.native") version "1.1.14"
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-core:2.26.1")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.26.1")
    //implementation("org.noamm:eventbus:1.0.2")
}

graalvmNative {
    binaries.named("main") {
        imageName.set(rootProject.name)
        mainClass.set(rootProject.name)
        // tasks.jar is disabled, so the default classpath would point at the shadow jar's path
        classpath.setFrom(sourceSets.main.get().output, configurations.runtimeClasspath)
    }
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
