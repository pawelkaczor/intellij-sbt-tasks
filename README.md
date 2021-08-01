[![Maven Central](https://maven-badges.herokuapp.com/maven-central/pl.newicom.ide.intellij/intellij-sbt-tasks/badge.svg)](https://maven-badges.herokuapp.com/maven-central/pl.newicom.ide.intellij/intellij-sbt-tasks)

# intellij-sbt-tasks

When SBT loads a project, Intellij Idea [Run/Debug configuration](https://www.jetbrains.com/help/idea/run-debug-configuration.html) 
files are generated by the plugin and stored in the ```<PROJECT ROOT>/.run``` directory.
Intellij Idea automatically discovers new Run/Debug configurations as well as new Run/Debug configuration templates 
defined in the configuration files.

The following Run/Debug configurations and Run/Debug configuration templates are generated by this plugin:

### Run/Debug configurations
- compile (Test/compile)
- recompile (clean Test/compile)
- publishLocal
- tests
- integrationTests


### Run/Debug configuration templates

#### ScalaTest template with Kamon instrumentation enabled

The template is not generated by default. You can generate the template by adding:  

```scala
ThisBuild / kamonInstrumentationEnabled := true
```

to the sbt settings and reloading the sbt.

### Installation

```scala
addSbtPlugin("pl.newicom.ide.intellij" % "intellij-sbt-tasks" % "<current version>")
```
