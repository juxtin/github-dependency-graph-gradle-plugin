package org.gradle.github.dependencygraph.internal

import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.Property
import org.gradle.api.services.BuildService
import org.gradle.api.services.BuildServiceParameters
import java.nio.file.Path

abstract class DependencyExtractorBuildService :
    DependencyExtractor(),
    BuildService<DependencyExtractorBuildService.Parameters> {

    interface Parameters : BuildServiceParameters {
        val gitHubJobName: Property<String>
        val gitHubRunNumber: Property<String>
        val gitSha: Property<String>
        val gitRef: Property<String>
        val gitWorkspaceDirectory: DirectoryProperty
        val gradleBuildPath: Property<String>
    }

    override val gitHubJobName: String
        get() = parameters.gitHubJobName.get()
    override val gitHubRunNumber: String
        get() = parameters.gitHubRunNumber.get()
    override val gitSha: String
        get() = parameters.gitSha.get()
    override val gitRef: String
        get() = parameters.gitRef.get()
    override val gitWorkspaceDirectory: Path
        get() = parameters.gitWorkspaceDirectory.get().asFile.toPath()
    override val gradleBuildPath: String
        get() = parameters.gradleBuildPath.get()
}