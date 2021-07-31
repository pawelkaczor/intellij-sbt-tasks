import ReleaseTransformations._

organization := "pl.newicom.ide.intellij"
name := "intellij-sbt-tasks"
sbtPlugin := true

homepage := Some(new URL("https://github.com/pawelkaczor/intellij-sbt-tasks"))
licenses := ("Apache2", new URL("https://raw.githubusercontent.com/pawelkaczor/intellij-sbt-tasks/master/LICENSE")) :: Nil

publishMavenStyle := true
publishTo := sonatypePublishToBundle.value

sonatypeProfileName := "pl.newicom"

versionScheme := Some("early-semver")
scalacOptions ++= Seq("-deprecation", "-feature")

Publish.settings

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommand("publishSigned"),
  releaseStepCommand("sonatypeBundleRelease"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
