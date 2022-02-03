package com.futureworkshops.gradle.dependency_check.model

import com.futureworkshops.gradle.dependency_check.domain.extension.toSemver
import com.github.glwithu06.semver.Semver

data class ModuleInformation(
    val minVersion: Semver,
    val maxVersion: Semver,
    val module: String
) {
    constructor(string: String):
            this(
                minVersion = string.split(":").toMutableList().removeLast().toSemver(useMajor = false),
                maxVersion = string.split(":").toMutableList().removeLast().toSemver(useMajor = true),
                module = string.split(":").dropLast(1).joinToString(":")
            )

    @Suppress("MemberVisibilityCanBePrivate")
    fun containsVersion(other: Semver?): Boolean = other != null && other in minVersion..maxVersion
    fun containsVersion(other: String?): Boolean = containsVersion(other?.toSemver())
}
