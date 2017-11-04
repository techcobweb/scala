organization := "techcobweb.scala"
name := "example001"
version := "1.0"

scalaVersion := Option(System.getProperty("scala.version")).getOrElse("2.11.4")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"

scalacOptions := Seq("-feature", "-deprecation")
