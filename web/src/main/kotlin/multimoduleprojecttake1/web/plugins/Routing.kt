package multimoduleprojecttake1.web.plugins

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.Serializable
import multimoduleprojecttake1.core.helloworld.HelloReply

@Serializable
data class Test(val taco: Boolean, val burrito: String)

fun Application.configureRouting() {

  // Starting point for a Ktor app:
  routing {
    get("/") {
      val helloReply = HelloReply.newBuilder()
      helloReply.message = "hi!!"
      val asdf = helloReply.build()

//      call.respondText { "hello world" }
      call.respond(Test(taco = true, burrito = "yes" ))
    }
  }
  routing {
  }
}
