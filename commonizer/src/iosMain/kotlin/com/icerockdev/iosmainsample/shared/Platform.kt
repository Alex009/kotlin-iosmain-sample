package com.icerockdev.iosmainsample.shared


import cocoapods.AFNetworking.AFNetworkingVersionString
import com.icerockdev.iosmainsample.interop.setAssociatedObject
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() +
            " " + UIDevice.currentDevice.systemVersion

    init {
        setAssociatedObject(this, "test")

        println(AFNetworkingVersionString)
    }
}
