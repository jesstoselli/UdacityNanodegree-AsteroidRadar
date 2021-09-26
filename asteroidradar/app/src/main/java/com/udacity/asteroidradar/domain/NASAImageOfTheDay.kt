package com.udacity.asteroidradar.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class NASAImageOfTheDay(
    val url: String,
    @Json(name = "media_type") val mediaType: String,
    val title: String
)
