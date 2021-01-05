plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

version = "1.0.0"

kotlin {
    val ios = listOf(iosX64(), iosArm64())
    configure(ios) {
        // not needed with cocoapods plugin
//        binaries {
//            framework {
//                baseName = "shared"
//            }
//        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2-native-mt")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting {
            dependsOn(iosX64Main)
        }
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
    cocoapods {
        summary = "Summary"
        homepage = "home"

        pod("AFNetworking")
    }
}
