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
