name := """web-app"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator





libraryDependencies ++= Seq(
  "com.typesafe.play" %% "anorm" % "2.3.6")

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.12")

  //fork in run := true

//fork in run := true