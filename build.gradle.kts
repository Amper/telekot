import java.time.Instant
import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val telekotArtifact: String by project
val telekotGroup: String by project
val telekotVersion: String by project
val telekotAuthor: String by project
val telekotDescription: String by project
val telekotUrl: String by project
val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val loggingVersion: String by project
val kotlinJacksonVersion: String by project
val kotestVersion: String by project
val mockkVersion: String by project
val detektVersion: String by project
val jacocoVersion: String by project
val junitVersion: String by project

description = telekotDescription
group = telekotGroup
version = telekotVersion

extra["isReleaseVersion"] = !telekotVersion.endsWith("SNAPSHOT")

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
    id("io.gitlab.arturbosch.detekt")
    id("org.jlleitschuh.gradle.ktlint")
    jacoco
    maven
    `maven-publish`
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    maven { url = uri("https://kotlin.bintray.com/kotlinx") }
    maven { url = uri("https://dl.bintray.com/microutils/kotlin-logging") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap/") }
}

configurations {
    implementation {
        resolutionStrategy.failOnVersionConflict()
    }
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    // KTOR Client
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-apache:$ktorVersion")
    implementation("io.ktor:ktor-client-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-gson:$ktorVersion")
    implementation("io.ktor:ktor-client-logging-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    // KTOR Server
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-gson:$ktorVersion")
    // Logging
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.github.microutils:kotlin-logging:$loggingVersion")
    // Testing
    testImplementation(kotlin("test", kotlinVersion))
    testImplementation(kotlin("test-junit5", kotlinVersion))
    testImplementation("io.ktor:ktor-client-mock:$ktorVersion")
    testImplementation("io.ktor:ktor-client-mock-jvm:$ktorVersion")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-extensions-allure-jvm:$kotestVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks {
    withType<KotlinCompile> {
        sourceCompatibility = JavaVersion.VERSION_11.toString()
        targetCompatibility = JavaVersion.VERSION_11.toString()
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }
    check {
        dependsOn(jacocoTestCoverageVerification)
        dependsOn(jacocoTestReport)
        dependsOn(detekt)
    }
    jacocoTestReport {
        reports {
            xml.isEnabled = true
            html.isEnabled = true
        }
    }
    jacoco {
        toolVersion = jacocoVersion
    }
    detekt {
        toolVersion = detektVersion
        input = files("src")
        config = files("${rootProject.projectDir}/detekt.yml")
        parallel = true
    }
    jar {
        manifest {
            attributes["Built-By"] = telekotAuthor
            attributes["Build-Jdk"] =
                "${System.getProperty("java.version")} (${System.getProperty("java.vendor")} ${System.getProperty("java.vm.version")})"
            attributes["Build-Timestamp"] = Instant.now().toString()
            attributes["Created-By"] = "Gradle ${gradle.gradleVersion}"
            attributes["Implementation-Title"] = project.name
            attributes["Implementation-Version"] = project.version
        }
    }
    test {
        useJUnitPlatform()
        finalizedBy(jacocoTestReport)
        testLogging {
            showStackTraces = true
            showExceptions = true
            showCauses = true
        }
    }
}

kotlin {
    experimental {
        coroutines = Coroutines.ENABLE
    }
    sourceSets {
        all {
            languageSettings.progressiveMode = true
            languageSettings.languageVersion = "1.4"
            languageSettings.apiVersion = "1.4"
            languageSettings.enableLanguageFeature("InlineClasses")
        }
        main {
            kotlin.srcDir("src")
            resources.srcDir("resources")
        }
        test {
            kotlin.srcDir("test")
            resources.srcDir("testresources")
        }
    }
}

publishing {
    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/alter-vision")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = telekotGroup
            artifactId = telekotArtifact
            version = telekotVersion
            description = telekotDescription

            from(components["java"])

            pom {
                name.set(telekotArtifact)
                description.set(telekotDescription)
                url.set(telekotUrl)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("Amper")
                        name.set("Alexander Marshalov")
                        email.set("_@marshalov.org")
                    }
                    developer {
                        id.set("eyrikh-n")
                        name.set("Nikita Eyrikh")
                    }
                    developer {
                        id.set("nikolko")
                        name.set("Nikolaev Sergey")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/alter-vision/telekot.git")
                    developerConnection.set("scm:git:git://github.com/alter-vision/telekot.git")
                    url.set("https://github.com/alter-vision/telekot")
                }
            }
        }
    }
}
