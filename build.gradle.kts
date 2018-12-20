plugins {
    java
    id("org.springframework.boot") version "2.1.1.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

group = "de.akelsch"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
}
