package multimoduleprojecttake1.web.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.Compression
import io.ktor.server.plugins.ConditionalHeaders
import io.ktor.server.plugins.deflate
import io.ktor.server.plugins.gzip
import io.ktor.server.plugins.minimumSize

fun Application.configureHTTP() {
  install(Compression) {
    gzip {
      priority = 1.0
    }
    deflate {
      priority = 10.0
      minimumSize(1024) // condition
    }
  }
  install(ConditionalHeaders)

}
