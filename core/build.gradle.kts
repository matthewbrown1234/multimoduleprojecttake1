import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

val coroutinesVersion: String by System.getProperties()
val protobufKotlinVersion: String by System.getProperties()
val protobufGradlePlugin: String by System.getProperties()

println("coroutines versions ====> " + coroutinesVersion)

plugins {
  id("multimoduleprojecttake1.kotlin-library-conventions")
  id("com.google.protobuf") version "0.8.18"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(project(":utilities"))
  implementation("com.google.protobuf:protobuf-kotlin:${protobufKotlinVersion}")
  implementation("com.google.protobuf:protobuf-gradle-plugin:${protobufGradlePlugin}")
}

sourceSets {
  main {
    proto {
      srcDir("src/main/protobuf")
    }
  }
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
