organization := "techcobweb.scala"
name := "examples"
version := "1.0"

scalaVersion := Option(System.getProperty("scala.version")).getOrElse("2.11.4")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"

scalacOptions := Seq("-feature", "-deprecation")

lazy val root = project.in( file(".") )
                       .aggregate( example001 , example020 )

lazy val example001 = project.in( file("example001") )
lazy val example020 = project.in( file("example020") )
