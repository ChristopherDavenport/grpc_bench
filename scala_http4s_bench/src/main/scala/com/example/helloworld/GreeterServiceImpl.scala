package io.grpc.examples.helloworld

import cats.effect.IO
import io.grpc.examples.helloworld.helloworld.{Greeter, HelloReply, HelloRequest}

class GreeterServiceImpl extends Greeter[IO] {
  override def sayHello(request: HelloRequest, ctx: org.http4s.Headers): IO[HelloReply] =
    IO.pure(HelloReply(request.request))
}


