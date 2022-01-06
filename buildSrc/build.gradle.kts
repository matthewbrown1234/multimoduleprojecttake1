val kotlinVersion: String by System.getProperties()
val coroutinesVersion: String by System.getProperties()

plugins {
    `kotlin-dsl`
}

println("kotlinVersion ====> " + kotlinVersion)
println("coroutines versions ====> " + coroutinesVersion)

repositories {
    gradlePluginPortal()
    mavenLocal()
    mavenCentral()
    google()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
}
