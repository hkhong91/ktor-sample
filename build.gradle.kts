val ktor_version: String by project
val ktorm_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
  application
  kotlin("jvm") version "1.5.31"
  id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.example"
version = "0.0.1"
application {
  mainClass.set("com.example.ApplicationKt")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("io.ktor:ktor-server-core:$ktor_version")
  implementation("io.ktor:ktor-server-netty:$ktor_version")
  implementation("io.ktor:ktor-gson:$ktor_version")
  implementation("org.ktorm:ktorm-core:${ktorm_version}")
  implementation("org.ktorm:ktorm-support-mysql:${ktorm_version}")
  implementation("mysql:mysql-connector-java:8.0.25")
  implementation("ch.qos.logback:logback-classic:$logback_version")
  testImplementation("io.ktor:ktor-server-tests:$ktor_version")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

tasks{
  shadowJar {
    manifest {
      attributes(Pair("Main-Class", "com.example.ApplicationKt"))
    }
  }
}