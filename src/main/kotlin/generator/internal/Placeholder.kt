package generator.internal

enum class Placeholder(value: String) {
    SERVICE_NAME("service-name"),
    COMPONENT("component"),
    NAMESPACE("namespace"),
    SUBPACKAGE("subpackage") {
        override fun replace(text: String, value: String): String {
            return text
                .replace("`${formatValue}`", value)
                .replace(formatValue, value)
        }
    },
    TEAM("team"),
    NEWRELIC_LICENSE_KEY_SECRET_NAME("newrelic-license-key-secret-name"),
    NEWRELIC_ENABLED("newrelic-enabled"),
    SLACK_WEBHOOK_SECRET_NAME_DEPLOYMENTS_NON_PROD("slack-webhook-secret-name-deployments-non-prod");

    val formatValue: String = "{{$value}}"

    open fun replace(text: String, value: String): String = text.replace(this.formatValue, value)
}

fun String.applyPlaceholder(placeholder: Placeholder, value: String) = placeholder.replace(this, value)