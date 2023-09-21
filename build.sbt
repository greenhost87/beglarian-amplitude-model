lazy val root = (project in file(".")).settings(
  organization                 := "fr.beglarian",
  scalaVersion                 := "3.3.0",
  name                         := "beglarian-amplitude-model",
  version                      := "0.0.3",
  libraryDependencies ++= Seq(
    "io.spray" %% "spray-json" % "1.3.6" % "compile"
  ),
  Compile / mappings           := Seq(),
  packageDoc / mappings        := Seq(),
  packageDoc / publishArtifact := false,
  githubOwner                  := "greenhost87",
  githubRepository             := "beglarian-amplitude-model"
)
