import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

val ktor_version: String by project
val logback_version: String by project
val kotlinVersion: String by System.getProperties()
val protobufKotlinVersion: String by System.getProperties()
val protobufGradlePlugin: String by System.getProperties()

version = "0.0.1"

plugins {
  id("multimoduleprojecttake1.kotlin-application-conventions")
  id("com.google.protobuf") version "0.8.18"
  id("org.jetbrains.kotlin.plugin.serialization") version "1.6.10"
}

application {
  mainClass.set("multimoduleprojecttake1.web.ApplicationKt")
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

  implementation(kotlin("stdlib"))
  implementation(project(":utilities"))
  implementation(project(":core"))

  implementation("io.ktor:ktor-server-compression:$ktor_version")
  implementation("io.ktor:ktor-server-conditional-headers:$ktor_version")
  implementation("io.ktor:ktor-server-call-logging:$ktor_version")
  implementation("io.ktor:ktor-server-core:$ktor_version")
  implementation("io.ktor:ktor-server-netty:$ktor_version")
  implementation("io.ktor:ktor-server-cio:$ktor_version")
  implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

  implementation("ch.qos.logback:logback-classic:$logback_version")
  implementation("com.google.protobuf:protobuf-kotlin:${protobufKotlinVersion}")
  implementation("com.google.protobuf:protobuf-gradle-plugin:${protobufGradlePlugin}")


  testImplementation("io.ktor:ktor-server-tests:$ktor_version")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:${kotlinVersion}")
}

protobuf {
  protoc {
    artifact = "com.google.protobuf:protoc:${protobufKotlinVersion}"
  }
//  plugins {
//    id("grpc") {
//      artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
//    }
//    id("grpckt") {
//      artifact = "io.grpc:protoc-gen-grpc-kotlin:${grpcKotlinVersion}:jdk7@jar"
//    }
//  }
  generateProtoTasks {
    all().forEach {
//      it.plugins {
//        id("grpc")
//        id("grpckt")
//      }
      it.builtins {
        id("kotlin")
      }
    }
  }
}
