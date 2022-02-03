package com.futureworkshops.gradle.dependency_check.model

import java.lang.Exception

data class RequestInformation(
    val module: String,
    val version: String?
) {
    @Throws(Exception::class)
    fun validateAgainst(maven: String) {
        val coreInfo = ModuleInformation(maven)
        val exception = VersionResolutionException(coreInfo)

        if (module == coreInfo.module && !coreInfo.containsVersion(version)) {
            throw exception
        }
    }
}
