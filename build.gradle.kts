import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

plugins {
    kotlin("jvm") version "1.4.10"
    application
}

group = "bitfinex-v2-wss-api-java"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    allprojects {
        repositories {
            maven { url = URI.create("https://jitpack.io") }
        }
    }

}

dependencies {
    testImplementation(kotlin("test-junit"))

    implementation("org.ta4j:ta4j-core:0.13")
    implementation("com.sun.mail:javax.mail:1.6.2")
    implementation("com.github.binance-exchange:binance-java-api:7781ee0549")
    implementation("org.json:json:20201115")
    implementation("com.google.guava:guava:29.0-jre")
    implementation("org.bboxdb:bboxdb-commons:0.9.5")
    implementation("org.glassfish.tyrus.bundles:tyrus-standalone-client-jdk:1.17")
    implementation("junit:junit:4.13.1")
    implementation("org.mockito:mockito-core:3.7.0")

}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}

