import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    kotlin
    java
    id("multimoduleprojecttake1.kotlin-application-conventions")
    id("com.google.protobuf") version "0.8.18"
}

val coroutinesVersion = "1.5.2"
val grpcVersion = "1.39.0" // need to wait for grpc kotlin to move past this
val protobufVersion = "3.19.1"
val grpcKotlinVersion = "1.2.0" // CURRENT_GRPC_KOTLIN_VERSION

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
    implementation(kotlin("stdlib"))

    implementation("io.grpc:grpc-netty:${grpcVersion}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
    implementation("io.grpc:grpc-kotlin-stub:${grpcKotlinVersion}")
    implementation("io.grpc:grpc-protobuf:${grpcVersion}")
    implementation("com.google.protobuf:protobuf-kotlin:${protobufVersion}")
    implementation("com.google.protobuf:protobuf-gradle-plugin:0.8.18")
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
        artifact = "com.google.protobuf:protoc:${protobufVersion}"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:${grpcKotlinVersion}:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
            it.builtins {
                id("kotlin")
            }
        }
    }
}

application {
    // Define the main class for the application.
    mainClass.set("multimoduleprojecttake1.app.AppKt")
}
