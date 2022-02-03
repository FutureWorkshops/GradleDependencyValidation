package com.futureworkshops.gradle.dependency_check.domain.extension

import com.github.glwithu06.semver.Semver

@Throws(IllegalArgumentException::class)
fun String.toSemver(useMajor: Boolean = true): Semver {
    return if (startsWith("[")) {
        val items = replace("[", "")
            .split(",")
        if (useMajor) {
            items.last()
        } else {
            items.first()
        }.let { Semver(it) }
    } else {
        Semver(this.trim())
    }
}