package pl.newicom.ide.intellij

import sbt.{Def, _}

object IntellijSbtTasksPlugin extends AutoPlugin {

  override def trigger = allRequirements

  private val commonTasks =
    Seq(
      "publishLocal.run.xml",
      "compile.run.xml",
      "recompile.run.xml",
      "release.run.xml",
      "tests.run.xml",
      "integrationTests.run.xml",
      "depBrowseTree.run.xml",
      "depBrowseTreeInTest.run.xml",
      "depBrowseTreeInIT.run.xml",
      "git-pull.run.xml",
    )
      .map(readResource)

  private val scalaTestWithKanelaAgentTemplate =
    readResource("kamon/Template ScalaTest.run.xml")

  object autoImport {
    val kamonInstrumentationEnabled = settingKey[Boolean]("Enable Kamon instrumentation")
  }

  import autoImport._

  override lazy val globalSettings: Seq[Setting[_]] = Seq(
    kamonInstrumentationEnabled := false,
  )

  override def projectSettings: Seq[Def.Setting[_]] =
    addCommandAlias("releaseWithDefaults", "release with-defaults")

  override def buildSettings: Seq[Def.Setting[_]] = {
    SettingKey[Unit]("intellijGenerateSbtTasks") := {
      val tasks = if (kamonInstrumentationEnabled.value) commonTasks :+ scalaTestWithKanelaAgentTemplate else commonTasks
      tasks.foreach {
        case (fileName, task) =>
          val f = file(".run" + fileName)
          if (!f.exists()) {
            IO.write(f, task)
          }
      }
    }
  }

  private def readResource: String => (String, String) = { path =>
    val fileName = path.split('/').toSeq.fold(path) { case (_, r) => r }
    (s"/$fileName", IO.readStream(IntellijSbtTasksPlugin.getClass.getResourceAsStream(s"/$path")))
  }

}
