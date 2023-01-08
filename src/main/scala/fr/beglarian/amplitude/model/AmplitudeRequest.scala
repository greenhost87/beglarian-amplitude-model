package fr.beglarian.amplitude.model

case class AmplitudeRequest(apiKey: String, events: Seq[AmplitudeEvent])
