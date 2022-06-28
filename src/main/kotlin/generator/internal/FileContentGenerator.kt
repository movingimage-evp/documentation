package generator.internal

import generator.Config
import generator.NewRelicConfig
import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.io.path.writeText

object FileContentGenerator {
    fun apply(path: Path) {
        val fileContent = path.readText()

        val newFileContent = fileContent
            .applyPlaceholder(Placeholder.SERVICE_NAME, Config.serviceName)
            .applyPlaceholder(Placeholder.COMPONENT, Config.component)
            .applyPlaceholder(Placeholder.NAMESPACE, Config.kubernetesNamespace)
            .applyPlaceholder(Placeholder.SUBPACKAGE, Config.subpackage)
            .applyPlaceholder(Placeholder.TEAM, Config.team)
            .applyPlaceholder(
                Placeholder.SLACK_WEBHOOK_SECRET_NAME_DEPLOYMENTS_NON_PROD,
                Config.slackWebhookSecretNameDeploymentsNonProd
            )
            .applyNewrelicConfig(Config.newRelic)

        if (fileContent != newFileContent) {
            path.writeText(newFileContent)
            println("Changed file: $path")
        }
    }

    private fun String.applyNewrelicConfig(newRelicConfig: NewRelicConfig): String {
        return this
            .applyPlaceholder(Placeholder.NEWRELIC_ENABLED, newRelicConfig.enabled.toString())
            .applyPlaceholder(Placeholder.NEWRELIC_LICENSE_KEY_SECRET_NAME, newRelicConfig.licenseKeySecretName)
    }
}