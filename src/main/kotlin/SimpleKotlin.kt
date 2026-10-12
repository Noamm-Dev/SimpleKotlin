import org.slf4j.Logger
import org.slf4j.LoggerFactory

object SimpleKotlin {
    val LOGGER: Logger = LoggerFactory.getLogger("SimpleKotlin")

    @JvmStatic
    fun main(args: Array<String>) {
        LOGGER.info("Hello World!")
    }
}