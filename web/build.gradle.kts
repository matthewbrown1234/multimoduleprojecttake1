val kotlin_version: String by rootProject
val ktor_version: String by project
val logback_version: String by project

plugins {
  `kotlin-dsl`
  application
  kotlin
  id("multimoduleprojecttake1.kotlin-application-conventions")
}

version = "0.0.1"
application {
  mainClass.set("multimoduleprojecttake1.web.ApplicationKt")
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(project(":utilities"))

  implementation("io.ktor:ktor-server-compression:$ktor_version")
  implementation("io.ktor:ktor-server-conditional-headers:$ktor_version")
  implementation("io.ktor:ktor-server-call-logging:$ktor_version")
  implementation("io.ktor:ktor-server-core:$ktor_version")
  implementation("io.ktor:ktor-server-netty:$ktor_version")
  implementation("ch.qos.logback:logback-classic:$logback_version")
  testImplementation("io.ktor:ktor-server-tests:$ktor_version")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

repositories {
  mavenCentral()
}
