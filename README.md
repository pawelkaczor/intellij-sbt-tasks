# intellij-sbt-tasks

Intellij Idea run configurations for Scala SBT projects:
- compile (Test/compile)
- recompile (clean Test/compile)
- publishLocal
- tests
- integrationTests
- ...

When SBT reloads a project, IJ Run Configuration files are generated by the plugin and stored in the <PROJECT ROOT>/.run directory.

### Installation

```scala
addSbtPlugin("pl.newicom.ide.intellij" % "intellij-sbt-tasks" % "<current version>")
```
