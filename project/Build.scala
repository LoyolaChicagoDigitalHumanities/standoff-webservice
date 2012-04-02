import sbt._
import Keys._
import com.typesafe.startscript.StartScriptPlugin

object Build extends sbt.Build {
  import Dependencies._

  lazy val myProject = Project("standoffmarkup-webservice-spray", file("."))
    .settings(StartScriptPlugin.startScriptForClassesSettings: _*)
    .settings(
      organization  := "edu.luc.etl.standoffmarkup",
      version       := "0.0.2",
      scalaVersion  := "2.9.1",
      scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8"),
      resolvers     ++= Dependencies.resolutionRepos,
      libraryDependencies ++= Seq(
        Compile.akkaActor,
        Compile.parboiled,
        Compile.mimepull,
        Compile.sprayServer,
        Compile.sprayCan,
        Compile.sprayJson,
        Test.specs2,
        Test.junit,
        Test.mockito,
        Container.akkaSlf4j,
        Container.slf4j,
        Container.logback,
        Compile.trang
      )
    )
}

object Dependencies {
  val resolutionRepos = Seq(
    "spray repo" at "http://repo.spray.cc",
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    ScalaToolsSnapshots
  )

  object V {
    val akka      = "1.3.1"
    val spray     = "0.9.0"
    val sprayCan  = "0.9.3"
    val sprayJson = "1.1.0"
    val parboiled = "1.0.2"
    val mimepull  = "1.6"
    val specs2    = "1.9-SNAPSHOT"
    val slf4j     = "1.6.4"
    val logback   = "1.0.0"
    val junit 	  = "4.7"
    val mockito   = "1.8.5"
    val trang   = "20091111"
  }

  object Compile {
    val akkaActor   = "se.scalablesolutions.akka" %  "akka-actor"      % V.akka    % "compile"
    val parboiled   = "org.parboiled"             %  "parboiled-scala" % V.parboiled % "compile"
    val mimepull    = "org.jvnet"                 %  "mimepull"        % V.mimepull  % "compile"
    val sprayServer = "cc.spray"                  %  "spray-server"    % V.spray     % "compile"
    val sprayCan    = "cc.spray"                  %  "spray-can"       % V.sprayCan  % "compile"
    val sprayJson   = "cc.spray"                  %% "spray-json"      % V.sprayJson % "compile"
    val trang       = "com.thaiopensource"        %  "trang"           % V.trang   % "compile"
  }

  object Test {
    val specs2      = "org.specs2"                %% "specs2"          % V.specs2  % "test"
    val junit       = "junit"                     %  "junit"           % V.junit     % "test"
    val mockito	    = "org.mockito" 		      %  "mockito-all"     % V.mockito   % "test"
  }

  object Container {
    val akkaSlf4j   = "se.scalablesolutions.akka" %  "akka-slf4j"      % V.akka
    val slf4j       = "org.slf4j"                 %  "slf4j-api"       % V.slf4j
    val logback     = "ch.qos.logback"            %  "logback-classic" % V.logback
  }
}
