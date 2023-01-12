package fr.beglarian.amplitude.model

case class AmplitudeUserProperties(
    email: Option[String],
    phone: Option[String],
    firstName: Option[String],
    lastName: Option[String],
    businessId: Option[String],
    date: Option[Long],
    role: String,
    custom: Map[String, String]
)