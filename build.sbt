ThisBuild / versionScheme := Some("early-semver")
ThisBuild / scalacOptions ++= Seq("-deprecation", "-feature")

organization := "pl.newicom.ide.intellij"

name := "intellij-sbt-tasks"

scalaVersion := "2.13.6"

publishMavenStyle := true
homepage := Some(new URL("http://github.com/pawelkaczor/intellij-sbt-tasks"))
licenses := (
  "Apache2",
  new URL("http://raw.githubusercontent.com/pawelkaczor/intellij-sbt-tasks/master/LICENSE")
) :: Nil
publishTo := sonatypePublishToBundle.value

sonatypeProfileName := "pl.newicom"
