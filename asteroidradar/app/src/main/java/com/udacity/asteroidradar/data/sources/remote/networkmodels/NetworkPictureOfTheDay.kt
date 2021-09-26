package com.udacity.asteroidradar.data.sources.remote.networkmodels

import com.squareup.moshi.Json

data class NetworkPictureOfTheDay(
    @Json(name = "media_type") val mediaType: String,
    val title: String,
    val url: String
)
