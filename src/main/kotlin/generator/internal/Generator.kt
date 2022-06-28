package generator.internal

import generator.Config
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.isRegularFile

class Generator {
    companion object {
        private val projectDirectory = Path(System.getProperty("user.dir"))
        private val ignoredPaths = setOf(".git", ".idea", "target").map { projectDirectory.resolve(it) }

        fun run() {
            printConfig()
            traverse({ it.isRegularFile() }, FileContentGenerator::apply)
            traverse({ true }, FileNameGenerator::apply)
            cleanUp()
            println("Generation completed!")
        }

        private fun cleanUp() {
            projectDirectory.resolve("src/main/kotlin/generator").toFile().deleteRecursively()
            println("Removed generator code")
        }

        private fun traverse(filter: (Path) -> Boolean, processor: (Path) -> Unit) {
            projectDirectory.toFile().walkBottomUp()
                .filter { file -> ignoredPaths.none { isChild(it, file.toPath()) } }
                .filter { file -> filter(file.toPath()) }
                .forEach { processor(it.toPath()) }
        }

        private fun isChild(path: Path, childCandidate: Path): Boolean {
            return childCandidate.startsWith(path)
        }

        private fun printConfig() {
            val config = mapOf(
                "Service name" to Config.serviceName,
                "Component" to Config.component,
                "k8 namespace" to Config.kubernetesNamespace,
                "Subpackage" to Config.subpackage,
                "Team" to Config.team,
                "Slack webhook secret name deployments non prod" to Config.slackWebhookSecretNameDeploymentsNonProd,
                "New Relic" to Config.newRelic,
            ).mapValues { it.value.toString() }

            println("Using following config values:")
            config.forEach {
                println("   ${it.key}: ${it.value}")
            }
        }
    }
}