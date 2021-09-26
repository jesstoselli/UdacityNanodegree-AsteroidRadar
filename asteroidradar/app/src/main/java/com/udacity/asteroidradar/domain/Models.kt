package com.udacity.asteroidradar.domain

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AsteroidRadar(
    val date: String,
    val id: String,
    val name: String,
    val absoluteMagnitude: Double,
    val estimatedDiameter: EstimatedDiameter,
    val isPotentiallyHazardousAsteroid: Boolean,
    val closeApproachData: CloseApproachData
) : Parcelable

@Parcelize
data class EstimatedDiameter(
    val kilometers: Diameters
) : Parcelable

@Parcelize
data class Diameters(
    @Json(name = "estimated_diameter_min")
    val minimum: Double,

    @Json(name = "estimated_diameter_max")
    val maximum: Double
) : Parcelable

@Parcelize
data class CloseApproachData(
    @Json(name = "relative_velocity")
    val relativeVelocity: List<RelativeVelocity>,

    val missDistance: MissDistance
) : Parcelable

@Parcelize
data class RelativeVelocity(
    @Json(name = "kilometers_per_second")
    val kilometerPerSecond: String
) : Parcelable

@Parcelize
data class MissDistance(
    val astronomical: String
) : Parcelable
