package com.udacity.asteroidradar.network.api

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class AsteroidRadarResponse(
    @Json(name = "near_earth_objects") val nearEarthObjects: List<NetworkNearEarthObjectsDate>
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class NetworkNearEarthObjectsDate(
    val eventDate: NetworkNearEarthObjects
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class NetworkNearEarthObjects(
    val id: String,
    val name: String,
    @Json(name = "absolute_magnitude_h") val absoluteMagnitude: Double,
    @Json(name = "estimated_diameter") val estimatedDiameter: NetworkEstimatedDiameter,
    @Json(name = "is_potentially_hazardous_asteroid") val isPotentiallyHazardousAsteroid: Boolean,
    @Json(name = "close_approach_data") val closeApproachData: NetworkCloseApproachData
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class NetworkEstimatedDiameter(
    val kilometers: NetworkDiameter
) : Parcelable

@JsonClass(generateAdapter = true)
@Parcelize
data class NetworkDiameter(
    @Json(name = "estimated_diameter_min")
    val minimum: Double,

    @Json(name = "estimated_diameter_max")
    val maximum: Double
) : Parcelable

@JsonClass(generateAdapter = true)
data class NetworkCloseApproachData(
    @Json(name = "relative_velocity")
    val relativeVelocity: List<NetworkRelativeVelocity>,

    val missDistance: NetworkMissDistance
)

@JsonClass(generateAdapter = true)
data class NetworkRelativeVelocity(
    @Json(name = "kilometers_per_second")
    val kilometerPerSecond: String
)

@JsonClass(generateAdapter = true)
data class NetworkMissDistance(
    val astronomical: String
)
//
//fun AsteroidRadarResponse.asDomainModel(): List<NetworkNearEarthObjectsDate> {
//    return eventDate.map {
//
//    }
//}
