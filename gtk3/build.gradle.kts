plugins {
    kotlin("multiplatform") version "1.3.21"
}

group = "com.github.kropp"
version = "0.1"

repositories {
    mavenCentral()
}

kotlin {
    linuxX64 {
        compilations.getByName("main") {
            val gtk3 by cinterops.creating {}
        }
    }
}
