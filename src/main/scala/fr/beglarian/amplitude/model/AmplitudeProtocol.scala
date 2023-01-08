package fr.beglarian.amplitude.model

import spray.json.*

object AmplitudeProtocol extends DefaultJsonProtocol {
  implicit val amplitudeEventFormat: RootJsonFormat[AmplitudeEvent] = new RootJsonFormat[AmplitudeEvent] {
    override def read(json: JsValue): AmplitudeEvent = {
      throw new NotImplementedError("Write only formatter")
    }

    override def write(e: AmplitudeEvent): JsValue = {
      val raw: Seq[(String, JsValue)] = Seq(
        Some("event_type" -> e.eventType.toJson),
        e.userId.map(v => "user_id" -> v.toJson),
        e.deviceId.map(v => "device_id" -> v.toJson),
        Some("timestamp" -> e.timestamp.toJson),
        e.locationLat.map(v => "location_lat" -> v.toJson),
        e.locationLng.map(v => "location_lng" -> v.toJson),
        e.appVersion.map(v => "app_version" -> v.toJson),
        e.platform.map(v => "platform" -> v.toJson),
        e.osName.map(v => "os_name" -> v.toJson),
        e.osVersion.map(v => "os_version" -> v.toJson),
        e.deviceBrand.map(v => "device_brand" -> v.toJson),
        e.deviceManufacturer.map(v => "device_manufacturer" -> v.toJson),
        e.deviceModel.map(v => "device_model" -> v.toJson),
        e.carrier.map(v => "carrier" -> v.toJson),
        e.country.map(v => "country" -> v.toJson),
        e.region.map(v => "region" -> v.toJson),
        e.city.map(v => "city" -> v.toJson),
        e.dma.map(v => "dma" -> v.toJson),
        e.idfa.map(v => "idfa" -> v.toJson),
        e.idfv.map(v => "idfv" -> v.toJson),
        e.adid.map(v => "adid" -> v.toJson),
        e.androidId.map(v => "android_id" -> v.toJson),
        Some("language" -> e.language.toJson),
        e.partnerId.map(v => "partner_id" -> v.toJson),
        Some("ip" -> e.ip.toJson),
        Some("event_properties" -> e.eventProperties.toJson),
        Some("user_properties" -> e.userProperties.toJson),
        e.price.map(v => "price" -> v.toJson),
        e.quantity.map(v => "quantity" -> v.toJson),
        e.revenue.map(v => "revenue" -> v.toJson),
        e.productId.map(v => "product_id" -> v.toJson),
        e.revenueType.map(v => "revenue_type" -> v.toJson),
        e.eventId.map(v => "event_id" -> v.toJson),
        e.sessionId.map(v => "session_id" -> v.toJson),
        Some("insert_id" -> e.insertId.toJson)
      ).flatten

      JsObject(raw: _*)
    }
  }

  implicit val amplitudeResponseFormat: RootJsonFormat[AmplitudeResponse] =
    jsonFormat(AmplitudeResponse.apply, "code", "status", "error")

  implicit val amplitudeRequestFormat: RootJsonFormat[AmplitudeRequest] =
    jsonFormat(AmplitudeRequest.apply, "api_key", "events")

  implicit val amplitudePathFormat: RootJsonFormat[AmplitudePath] =
    jsonFormat(AmplitudePath.apply, "path", "params")

  implicit val amplitudeEventPropertiesFormat: RootJsonFormat[AmplitudeEventProperties] =
    new RootJsonFormat[AmplitudeEventProperties] {
      override def read(json: JsValue): AmplitudeEventProperties = {
        throw new NotImplementedError("Write only formatter")
      }

      override def write(aep: AmplitudeEventProperties): JsValue = {
        val raw: Seq[(String, JsValue)] = Seq(
          "device_id" -> aep.deviceId.toJson,
          "session_id" -> aep.sessionId.toJson,
          "domain" -> aep.domain.toJson,
          "path" -> aep.path.toJson
        ) ++ aep.custom.map { case (key, value) =>
          key -> value.toJson
        }

        JsObject(raw: _*)
      }
    }

  implicit val amplitudeUserPropertiesFormat: RootJsonFormat[AmplitudeUserProperties] =
    jsonFormat(
      AmplitudeUserProperties.apply,
      "email",
      "phone",
      "first_name",
      "last_name",
      "business_id",
      "date",
      "role"
    )
}
