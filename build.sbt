name := "SecondTry"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  val akkaV = "2.4.3"
  val postgresV = "9.4.1210"
  val slickV = "3.1.1"
  Seq(
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
    "org.postgresql" % "postgresql" % postgresV,
    "com.typesafe.slick" %% "slick-hikaricp" % slickV
  )
}
