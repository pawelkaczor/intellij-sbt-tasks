package pl.newicom.ide.intellij

import sbt._

object IntellijSbtTasksPlugin extends AutoPlugin {

  private val taskFileNames: Seq[String] = Seq(
    "/publishLocal.run.xml",
    "/compile.run.xml",
    "/recompile.run.xml",
    "/tests.run.xml",
    "/integrationTests.run.xml",
  )

  private val tasks: Seq[(String, String)] =
    taskFileNames.map(f => (f, IO.readStream(IntellijSbtTasksPlugin.getClass.getResourceAsStream(f))))

  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = {
    SettingKey[Unit]("intellijGenerateSbtTasks") := {
      tasks.foreach {
        case (fileName, task) =>
          val f = file(".run" + fileName)
          if (!f.exists()) {
            IO.write(f, task)
          }
      }
    }
  }

}
