package com.udacity.asteroidradar.data.sources.remote

import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.domain.PictureOfDay
import com.udacity.asteroidradar.data.sources.remote.networkmodels.NetworkAsteroid
import com.udacity.asteroidradar.data.sources.remote.networkmodels.NetworkPictureOfTheDay

fun List<Asteroid>.toNetworkModel(): List<NetworkAsteroid> {
    return map {
        NetworkAsteroid(
            id = it.id,
            codename = it.codename,
            closeApproachDate = it.closeApproachDate,
            absoluteMagnitude = it.absoluteMagnitude,
            estimatedDiameter = it.estimatedDiameter,
            relativeVelocity = it.relativeVelocity,
            distanceFromEarth = it.distanceFromEarth,
            isPotentiallyHazardous = it.isPotentiallyHazardous
        )
    }
}

fun List<NetworkAsteroid>.toDomainModel(): List<Asteroid> {
    return map {
        Asteroid(
            id = it.id,
            codename = it.codename,
            closeApproachDate = it.closeApproachDate,
            absoluteMagnitude = it.absoluteMagnitude,
            estimatedDiameter = it.estimatedDiameter,
            relativeVelocity = it.relativeVelocity,
            distanceFromEarth = it.distanceFromEarth,
            isPotentiallyHazardous = it.isPotentiallyHazardous
        )
    }
}

fun NetworkPictureOfTheDay.toDomainModel(): PictureOfDay {
    return PictureOfDay(
        mediaType = this.mediaType,
        title = this.title,
        url = this.url
    )
}

fun PictureOfDay.toNetworkModel(): NetworkPictureOfTheDay {
    return NetworkPictureOfTheDay(
        mediaType = this.mediaType,
        title = this.title,
        url = this.url
    )
}