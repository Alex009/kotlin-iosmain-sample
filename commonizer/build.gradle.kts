plugins {
    kotlin("multiplatform")
}

kotlin {
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val iosMain by getting
    }
}
