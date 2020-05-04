import java.time.Instant
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val group: String by project
val version: String by project
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
val author: String by project

description = "Library for creating Telegram bots."
extra["isReleaseVersion"] = !version.endsWith("SNAPSHOT")

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
    id("io.gitlab.arturbosch.detekt")
    id("org.jlleitschuh.gradle.ktlint")
    jacoco
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

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-apache:$ktorVersion")
    implementation("io.ktor:ktor-client-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-gson:$ktorVersion")
    implementation("io.ktor:ktor-client-logging-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.github.microutils:kotlin-logging:$loggingVersion")
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
            attributes["Built-By"] = author
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
    }
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")
