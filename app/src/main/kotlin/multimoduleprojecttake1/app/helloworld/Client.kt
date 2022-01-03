package multimoduleprojecttake1.app.helloworld

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.io.Closeable
import java.util.concurrent.TimeUnit
import org.apache.commons.lang.StringUtils
import org.apache.commons.lang.WordUtils

class HelloWorldClient(private val channel: ManagedChannel) : Closeable {
    private val stub: GreeterGrpcKt.GreeterCoroutineStub =
        GreeterGrpcKt.GreeterCoroutineStub(channel)

    suspend fun greet(name: String, newName: String) {
        val request = helloRequest { this.name = name; this.newName = newName }
        val response = stub.sayHello(request)
        println("Received: ${response.message}")
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }
}


suspend fun main() {
    val tokens = StringUtils.split(MessageUtils.getMessage())
    val result = StringUtils.join(tokens)
    println(WordUtils.capitalize(result))

    val port = 50051

    val channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext().build()

    val client = HelloWorldClient(channel)

    client.greet("world", "tacos")
}
