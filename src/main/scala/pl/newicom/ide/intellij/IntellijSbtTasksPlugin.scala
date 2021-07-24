package pl.newicom.ide.intellij

import sbt._

object IntellijSbtTasksPlugin extends AutoPlugin {

  private val publishLocalTask: String =
    IO.readStream(IntellijSbtTasksPlugin.getClass.getResourceAsStream("/publishLocal.run.xml"))

  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = {
    SettingKey[Unit]("intellijGenerateSbtTasks") := {
      val publishLocalTaskFile = file(".run/publishLocal.run.xml")
      if (!publishLocalTaskFile.exists()) {
        IO.write(publishLocalTaskFile, publishLocalTask)
      }
    }
  }

}
