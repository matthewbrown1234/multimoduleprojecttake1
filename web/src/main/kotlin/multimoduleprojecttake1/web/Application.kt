package multimoduleprojecttake1.web

import multimoduleprojecttake1.web.plugins.configureRouting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import multimoduleprojecttake1.web.plugins.configureHTTP
import multimoduleprojecttake1.web.plugins.configureMonitoring

fun main() {
  embeddedServer(Netty, port = 8181, host = "0.0.0.0") {
    configureHTTP()
    configureMonitoring()
    configureRouting()
  }.start(wait = true)
}
