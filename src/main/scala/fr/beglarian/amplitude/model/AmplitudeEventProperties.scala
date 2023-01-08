package fr.beglarian.amplitude.model

case class AmplitudeEventProperties(
    deviceId: String,
    sessionId: String,
    path: AmplitudePath,
    domain: String,
    custom: Seq[(String, String)]
)
