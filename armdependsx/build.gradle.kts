plugins {
    kotlin("multiplatform")
}

kotlin {
    val ios = listOf(iosX64(), iosArm64())
    configure(ios) {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val iosX64Main by getting
        val iosArm64Main by getting {
            dependsOn(iosX64Main)
        }
    }
}
