package com.futureworkshops.gradle.dependency_check.model

data class VersionResolutionException(
    val module: ModuleInformation
): Exception(
    "Please, verify if all selected plugins are compatible with ${module.module} version ${module.minVersion}"
)