package generator.internal

import generator.Config
import org.apache.commons.io.FileUtils
import java.io.File
import java.nio.file.Path
import kotlin.io.path.isDirectory
import kotlin.io.path.name

object FileNameGenerator {
    private fun subpackageAsPath() = Config.subpackage.replace(".", File.separator)

    private fun contains(text: String, placeholder: Placeholder) = text.contains(placeholder.formatValue)

    fun apply(path: Path) {
        if (contains(path.name, Placeholder.SERVICE_NAME) || contains(path.name, Placeholder.SUBPACKAGE)) {
            val newName = path.name
                .applyPlaceholder(Placeholder.SERVICE_NAME, Config.serviceName)
                .applyPlaceholder(Placeholder.SUBPACKAGE, subpackageAsPath())

            val newPath = path.resolveSibling(newName)

            if (path.isDirectory()) {
                FileUtils.moveDirectory(path.toFile(), newPath.toFile())
            } else {
                path.toFile().renameTo(newPath.toFile())
            }

            println("Renamed $path to $newPath")
        }
    }
}