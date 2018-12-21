name := """agenda"""
organization := "br.edu.ifrn"

version := "1.0-SNAPSHOT"

//lazy val root = (project in file(".")).enablePlugins(PlayJava)

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.7"
libraryDependencies += javaJdbc
libraryDependencies += "com.h2database" % "h2" % "1.4.197"
libraryDependencies += guice

/*
libraryDependencies ++= Seq(
    javaJdbc,
    javaEbean,
    cache,
    "com.google.guava" % "guava" % "14.0",
    filters
)*/

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
//EclipseKeys.preTasks := Seq(compile in Compile, compile in Test)
