package multimoduleprojecttake1.web

import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import multimoduleprojecttake1.web.plugins.configureHTTP
import multimoduleprojecttake1.web.plugins.configureMonitoring
import multimoduleprojecttake1.web.plugins.configureRouting

fun main() {
  embeddedServer(CIO, port = 8181, host = "0.0.0.0") {
    configureHTTP()
    configureMonitoring()
    configureRouting()
  }.start(wait = true)
}
