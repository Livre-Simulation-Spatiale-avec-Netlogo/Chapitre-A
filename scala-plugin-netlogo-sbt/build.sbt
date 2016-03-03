
enablePlugins(org.nlogo.build.NetLogoExtension)

scalaVersion := "2.9.3"

netLogoExtName      := "my-extension"

netLogoClassManager := "MyExtension"

netLogoZipSources   := false

scalaSource in Compile := baseDirectory.value / "src"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xlint", "-Xfatal-warnings",
  "-encoding", "us-ascii")

netLogoTarget :=
  org.nlogo.build.NetLogoExtension.directoryTarget(baseDirectory.value)

val netLogoJarURL = Option(System.getProperty("netlogo.jar.url")).getOrElse("https://github.com/NetLogo/NetLogo/releases/download/5.3.0/NetLogo.jar")

val netLogoJarOrDependency = {
  import java.io.File
  import java.net.URI
  if (netLogoJarURL.startsWith("file:"))
    Seq(unmanagedJars in Compile += new File(new URI(netLogoJarURL)))
  else
    Seq(libraryDependencies += "org.nlogo" % "NetLogo" % "5.3.0" from netLogoJarURL)
}

netLogoJarOrDependency
