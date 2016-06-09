name := """calculator-fe"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test
)

libraryDependencies += "org.scalaj" % "scalaj-http_2.11" % "2.3.0"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"


scriptClasspath += "conf/*"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

//disablePlugins(PlayLayoutPlugin)

fork in run := true