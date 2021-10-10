package com.udacity.asteroidradar.data.sources.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.data.sources.remote.networkmodels.NetworkPictureOfTheDay
import com.udacity.asteroidradar.utils.Constants
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface AsteroidRadarApiService {
    @GET("neo/rest/v1/feed")
    fun getAsteroidsAsync(
        @Query("start_date") start: String,
        @Query("end_date") end: String,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Deferred<ResponseBody>
}

interface PictureOfTheDayService {
    @GET("planetary/apod")
    fun getPictureOfDayAsync(
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): Deferred<NetworkPictureOfTheDay>
}

object NetworkApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val asteroidService: AsteroidRadarApiService by lazy {
        retrofit.create(
            AsteroidRadarApiService::class.java
        )
    }

    val pictureOfTheDayService: PictureOfTheDayService by lazy {
        retrofit.create(
            PictureOfTheDayService::class.java
        )
    }
}