package fr.beglarian.amplitude.model

import java.time.Instant
import java.util.UUID

/** @param eventType
  *   A unique identifier for your event.
  * @param userId
  *   A readable ID specified by you. Must have a minimum length of 5 characters. Required unless device_id is present.
  * @param deviceId
  *   A device-specific identifier, such as the Identifier for Vendor on iOS. Required unless user_id is present. If a
  *   device_id is not sent with the event, it will be set to a hashed version of the user_id.
  * @param timestamp
  *   The timestamp of the event in milliseconds since epoch. If time is not sent with the event, it will be set to the
  *   request upload time.
  * @param locationLat
  *   The current Latitude of the user.
  * @param locationLng
  *   The current Longitude of the user.
  * @param appVersion
  *   The current version of your application.
  * @param platform
  *   Platform of the device
  * @param osName
  *   The name of the mobile operating system or browser that the user is using.
  * @param osVersion
  *   The version of the mobile operating system or browser the user is using.
  * @param deviceBrand
  *   The device brand that the user is using.
  * @param deviceManufacturer
  *   The device manufacturer that the user is using.
  * @param deviceModel
  *   The device model that the user is using.
  * @param carrier
  *   The carrier that the user is using.
  * @param country
  *   The current country of the user.
  * @param region
  *   The current region of the user.
  * @param city
  *   The current city of the user.
  * @param dma
  *   The current Designated Market Area of the user.
  * @param idfa
  *   (iOS) Identifier for Advertiser.
  * @param idfv
  *   (iOS) Identifier for Vendor.
  * @param adid
  *   (Android) Google Play Services advertising ID
  * @param androidId
  *   (Android) Android ID (not the advertising ID)
  * @param language
  *   The (human) language set by the user.
  * @param partnerId
  *   The partner id of event
  * @param ip
  *   The IP address of the user. Use "$remote" to use the IP address on the upload request. We will use the IP address
  *   to reverse lookup a user's location (city, country, region, and DMA). Amplitude has the ability to drop the
  *   location and IP address from events once it reaches our servers. You can submit a request to our platform
  *   specialist team here to configure this for you.
  * @param eventProperties
  *   A dictionary of key-value pairs that represent additional data to be sent along with the event. You can store
  *   property values in an array. Date values are transformed into string values. Object depth may not exceed 40
  *   layers.
  * @param userProperties
  *   A dictionary of key-value pairs that represent additional data tied to the user. You can store property values in
  *   an array. Date values are transformed into string values. Object depth may not exceed 40 layers.
  * @param price
  *   The price of the item purchased. Required for revenue data if the revenue field is not sent. You can use negative
  *   values to indicate refunds.
  * @param quantity
  *   The quantity of the item purchased. Defaults to 1 if not specified.
  * @param revenue
  *   revenue = price * quantity. If you send all 3 fields of price, quantity, and revenue, then (price * quantity) will
  *   be used as the revenue value. You can use negative values to indicate refunds.
  * @param productId
  *   An identifier for the item purchased. You must send a price and quantity or revenue with this field.
  * @param revenueType
  *   The type of revenue for the item purchased. You must send a price and quantity or revenue with this field.
  * @param eventId
  *   An incrementing counter to distinguish events with the same user_id and timestamp from each other. We recommend
  *   you send an event_id, increasing over time, especially if you expect events to occur simultanenously.
  * @param sessionId
  *   The start time of the session in milliseconds since epoch (Unix Timestamp), necessary if you want to associate
  *   events with a particular system. A session_id of -1 is the same as no session_id specified.
  * @param insertId
  *   A unique identifier for the event. We will deduplicate subsequent events sent with an insert_id we have already
  *   seen before within the past 7 days. We recommend generation a UUID or using some combination of device_id,
  *   user_id, event_type, event_id, and time.
  */
case class AmplitudeEvent(
    eventType: String,
    userId: Option[String],
    deviceId: Option[String],
    timestamp: Long,
    eventProperties: AmplitudeEventProperties,
    userProperties: AmplitudeUserProperties,
    language: String,
    ip: String,
    locationLat: Option[Double] = None,
    locationLng: Option[Double] = None,
    appVersion: Option[String] = None,
    platform: Option[String] = None,
    osName: Option[String] = None,
    osVersion: Option[String] = None,
    deviceBrand: Option[String] = None,
    deviceManufacturer: Option[String] = None,
    deviceModel: Option[String] = None,
    carrier: Option[String] = None,
    country: Option[String] = None,
    region: Option[String] = None,
    city: Option[String] = None,
    dma: Option[String] = None,
    idfa: Option[String] = None,
    idfv: Option[String] = None,
    adid: Option[String] = None,
    androidId: Option[String] = None,
    partnerId: Option[String] = None,
    price: Option[Double] = None,
    quantity: Option[Int] = None,
    revenue: Option[Double] = None,
    productId: Option[String] = None,
    revenueType: Option[String] = None,
    eventId: Option[Int] = None,
    sessionId: Option[Long] = None,
    insertId: String = UUID.randomUUID().toString
)
