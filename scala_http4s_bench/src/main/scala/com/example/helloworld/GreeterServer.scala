package io.grpc.examples.helloworld

import cats.effect._
import org.http4s.ember.server.EmberServerBuilder
import io.grpc.examples.helloworld.helloworld.Greeter
import org.http4s.implicits._
import com.comcast.ip4s._

object GreeterServer extends IOApp {
  val port = port"50051"
  val impl = new GreeterServiceImpl()
  val app = Greeter.toRoutes(impl).orNotFound
  def run(args: List[String]): IO[ExitCode] = {
    EmberServerBuilder
      .default[IO]
      .withHttp2
      .withPort(port)
      .withHttpApp(app)
      .build
      .useForever
  }
}

