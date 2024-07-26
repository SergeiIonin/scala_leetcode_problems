import org.jetbrains.sbt.extractors.SettingKeys.idePackagePrefix

ThisBuild / organization := "io.github.sergeiionin"
ThisBuild / scalaVersion := "3.4.2"

lazy val leetcode = project
  .settings(
    name := "scala_leetcode_problems",
    idePackagePrefix := Some("io.github.sergeiionin.scalaleetcode"),
    libraryDependencies ++= Seq(
      // "core" module - IO, IOApp, schedulers
      // This pulls in the kernel and std modules automatically.
      "org.typelevel" %% "cats-effect" % "3.5.3",
      // concurrency abstractions and primitives (Concurrent, Sync, Async etc.)
      "org.typelevel" %% "cats-effect-kernel" % "3.5.3",
      // standard "effect" library (Queues, Console, Random etc.)
      "org.typelevel" %% "cats-effect-std" % "3.5.3",
      "org.typelevel" %% "cats-effect-testing-specs2" % "1.5.0" % Test,
      "org.typelevel" %% "munit-cats-effect" % "2.0.0" % Test,
      "org.scalatest" %% "scalatest"         % "3.2.19" % Test,
      "org.specs2"    %% "specs2-cats"       % "4.20.8" % Test,
      "org.typelevel" %% "cats-effect-testing-scalatest" % "1.5.0" % Test
    )
  )
