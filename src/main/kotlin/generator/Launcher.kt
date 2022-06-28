package generator

import generator.internal.Generator

object Config {
    /**
     * Name of new service, that will be used in deployment and in maven as an artifactId
     *
     * Example: webcast-player-api
     */
    val serviceName: String = TODO("Specify service name")

    /**
     * Name of system component
     *
     * Example: webcast-v2
     */
    val component: String = TODO("Specify component name")

    /**
     * k8 namespace
     *
     * Example: webcast
     */
    val kubernetesNamespace: String = TODO("Specify k8 namespace")

    /**
     * Determines base package name in main module: com.movingimage.{subpackage}
     *
     * Example: player
     */
    val subpackage: String = TODO("Specify base package")

    /**
     * Name of movingimage team, please refer to
     * [movingimage teams list](https://github.com/orgs/movingimage-evp/teams)
     *
     * Example: hai5
     */
    val team: String = TODO("Specify team name")

    /**
     * TODO
     * If you would like to receive notifications about non production deployments, specify the name of the github
     * secret containing your slack channel webhook url. Otherwise leave empty.
     *
     * Example: SLACK_WEBHOOK_TEAM_HAI5_DEPLOYMENTS
     */
    val slackWebhookSecretNameDeploymentsNonProd: String = "";

    /**
     * New Relic configuration. Refer to [NewRelicConfig] for details.
     */
    val newRelic: NewRelicConfig = NewRelicConfig(
        enabled = false,
        licenseKeySecretName = TODO("Specify New Relic license key name")
    )
}

data class NewRelicConfig(
    /**
     * Enables New Relic support
     *
     * If set to `false`, configuration for New Relic will not be injected during deployment.
     * You can freely switch this parameter in [values.yaml] later on.
     */
    val enabled: Boolean,
    /**
     * New Relic license key secret name.
     *
     * If New Relic is disabled, you still can specify this parameter value for future usage.
     *
     * Example: NEWRELIC_LICENSE_KEY_TEAM_HAI5
     */
    val licenseKeySecretName: String
)

fun main() = Generator.run()
