package multimoduleprojecttake1.web.plugins

import io.ktor.server.plugins.*
import io.ktor.server.application.*

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
