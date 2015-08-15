name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

libraryDependencies ++= Seq(
  "org.webjars" % "react" % "0.13.3",
  "org.webjars" % "jquery" % "2.1.4",
  "org.webjars" % "requirejs" % "2.1.18",
  "com.github.tototoshi" %% "play-json4s-native" % "0.4.1",
  "com.github.tototoshi" %% "play-json4s-test-native" % "0.4.1" % "test"
)


resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
