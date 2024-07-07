import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.0.0"
    id("io.exoquery.terpal-plugin") version "2.0.0-0.2.0"
    kotlin("plugin.serialization") version "2.0.0"
    application
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    mavenLocal()
}

dependencies {
    api("io.exoquery:terpal-sql-jdbc:2.0.0-0.2.0")

    api("org.jetbrains.kotlinx:kotlinx-serialization-core:1.6.2")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")

    implementation("org.postgresql:postgresql:42.7.0")
}

application {
    mainClass.set("io.deusaquilus.ExampleKt")
}