package com.futureworkshops.gradle.dependency_check.model

import java.lang.Exception

data class RequestInformation(
    val module: String,
    val version: String
) {
    @Throws(Exception::class)
    fun validateAgainst(version: String) {
        val coreInfo = ModuleInformation(version)
        val exception = Exception("Please, verify if all selected plugins are compatible with core ${coreInfo.minVersion}")

        if (module == coreInfo.module && !coreInfo.containsVersion(version)) {
            throw exception
        }
    }
}
