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
    kotlin {
        targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget>().all {
            compilations.getByName("main") {
                val objcAddtition by cinterops.creating {
                    defFile(rootProject.file("objcAddtition.def"))
                }
            }
        }
    }
}
