package com.futureworkshops.gradle.dependency_check

import com.futureworkshops.gradle.dependency_check.model.RequestInformation
import com.futureworkshops.gradle.dependency_check.model.VersionResolutionException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class TestCoreResolution {

    private val coreMaven by lazy { "com.futureworkshops.mobileworkflow:mw-core:[2.0.0,2.1[" }

    @Test
    fun testValidVersion() {
        val validCoreModule = "com.futureworkshops.mobileworkflow:mw-core"
        val validCoreVersion = "2.0.0"

        val request = RequestInformation(module = validCoreModule, version = validCoreVersion)
        assertDoesNotThrow("Valid version should not throw") {
            request.validateAgainst(coreMaven)
        }
    }

    @Test
    fun testVersionRange() {
        val validCoreModule = "com.futureworkshops.mobileworkflow:mw-core"
        val validCoreVersion = "[2.0,2.1["

        val request = RequestInformation(module = validCoreModule, version = validCoreVersion)
        assertDoesNotThrow("Valid version should not throw") {
            request.validateAgainst(coreMaven)
        }
    }

    @Test
    fun testInvalidVersion() {
        val validCoreModule = "com.futureworkshops.mobileworkflow:mw-core"
        val validCoreVersion = "1.0.26"

        val request = RequestInformation(module = validCoreModule, version = validCoreVersion)
        assertThrows<VersionResolutionException>("Invalid version should throw") {
            request.validateAgainst(coreMaven)
        }
    }

}