import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "br.com.narigone",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Converter",
    libraryDependencies ++= {
      Seq(
        "ch.qos.logback" % "logback-classic" % "1.1.2",
        "com.typesafe.akka" % "akka-actor_2.11" % "2.4.1",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
        "org.scalactic" %% "scalactic" % "3.0.0",
        "org.scalatest" %% "scalatest" % "3.0.0" % "test"
      )
    }
  )
