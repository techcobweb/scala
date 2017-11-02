organization := "net.thecobbett.scala"
name := "scala"
version := "1.0"

scalaVersion := Option(System.getProperty("scala.version")).getOrElse("2.11.4")

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"

scalacOptions := Seq("-feature", "-deprecation")

lazy val root = project.in( file(".") )
                       .aggregate( example1 )

lazy val example1 = project.in( file("example1") )
