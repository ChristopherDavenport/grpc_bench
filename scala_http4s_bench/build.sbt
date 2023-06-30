name := "http4s-grpc-quickstart-scala"

version := "1.0"

scalaVersion := "2.13.11"

run / fork := true

enablePlugins(Http4sGrpcPlugin)

Compile / PB.targets ++= Seq(
  // set grpc = false because http4s-grpc generates its own code
  scalapb.gen(grpc = false) -> (Compile / sourceManaged).value / "scalapb"
)