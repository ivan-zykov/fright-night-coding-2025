plugins {
    kotlin("jvm") version "2.2.0"
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "8.14.3"
    }
}
