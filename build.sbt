ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.2"

lazy val root = (project in file("."))
  .settings(
    name := "crypto-analyzer"
  )


libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.9",
  "dev.zio" %% "zio-streams" % "2.0.9",
  "dev.zio" %% "zio-kafka" % "2.9.0",
  "dev.zio" %% "zio-json" % "0.7.4",
  "org.apache.spark" % "spark-core_2.13" % "3.5.0",
  "org.apache.spark" % "spark-sql_2.13" % "3.5.0",
  "dev.zio" %% "zio-kafka-testkit" % "2.9.0" % Test,
)

dependencyOverrides += "com.github.luben" % "zstd-jni" % "1.5.6-4"
//excludeDependencies += "org.scala-lang.modules" % "scala-collection-compat_2.13"
