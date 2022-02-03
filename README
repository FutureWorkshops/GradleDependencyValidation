# GradleDependencyValidation

This set of method allows you to improve the Gradle transient resolution and raise a meaningful error
when one of your dependencies attempts to use a version older than expected.

For example, given the configuration:

```kotlin
dependencies {
    implementation("group:artefact:1.0.0")
}

//region Core validation
configurations.all {
    resolutionStrategy.eachDependency {
        com.futureworkshops.gradle.dependency_check.model.RequestInformation(
            module = requested.module.toString(),
            version = requested.version
        ).validateAgainst("group:artefact:2.0.0")
    }
}
//endregion
```

The gradle commands will fail with the error:

```sh
$ gradle assemble

* What went wrong:
Execution failed for task ':app:checkDebugAarMetadata'.
> Could not resolve all files for configuration ':app:debugRuntimeClasspath'.
   > Could not resolve group:artefact:1.0.0.
     Required by:
         project :app
      > Please, verify if all selected plugins are compatible with group:artefact 2.0.0
```

## Installation

```kotlin
//build.gradle.kts
buildscript {
    val kotlinVersion by extra("1.5.32")
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        //Include the GradleDependencyValidation into the buildscript phase
        classpath("com.github.FutureWorkshops:GradleDependencyValidation:[1.0,1.1[")
    }
}
```

## Usage

```kotlin
//app/build.gradle.kts
//region Core validation
configurations.all {
    resolutionStrategy.eachDependency {
        com.futureworkshops.gradle.dependency_check.model.RequestInformation(
            module = requested.module.toString(),
            version = requested.version
        ).validateAgainst("group:artefact:1.0.0")
    }
}
//endregion
```

## Dynamic version

This script also allows the usage of maven dynamic version like `[2.0,2.1[`, where a minimum and maximum version is set.

```kotlin
//app/build.gradle.kts
//region Core validation
configurations.all {
    resolutionStrategy.eachDependency {
        com.futureworkshops.gradle.dependency_check.model.RequestInformation(
            module = requested.module.toString(),
            version = requested.version
        ).validateAgainst("group:artefact:[1.0,1.1[")
    }
}
//endregion
```