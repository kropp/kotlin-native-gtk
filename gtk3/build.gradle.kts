plugins {
    kotlin("multiplatform") version "1.3.41"
    `maven-publish`
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

    sourceSets {
        val linuxX64Main by getting {
            kotlin.srcDir("src/linuxX64Main/generatedKotlin")
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "5.4.1"
    distributionType = Wrapper.DistributionType.ALL
}
