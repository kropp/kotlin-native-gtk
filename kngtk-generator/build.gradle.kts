plugins {
    kotlin("jvm") version "1.3.41"
}

group = "kngtk-generator"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.squareup", "kotlinpoet", "1.0.1")
    implementation("org.jdom", "jdom2", "2.0.6")

    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.4.0")
    testImplementation("org.hamcrest", "hamcrest", "2.1")
}
