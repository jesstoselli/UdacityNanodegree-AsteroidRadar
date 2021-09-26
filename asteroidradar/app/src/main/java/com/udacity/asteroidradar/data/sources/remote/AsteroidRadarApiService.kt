package com.udacity.asteroidradar.data.sources.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.data.sources.remote.networkmodels.NetworkAsteroid
import com.udacity.asteroidradar.data.sources.remote.networkmodels.NetworkPictureOfTheDay
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val httpClient = OkHttpClient.Builder()
    .addInterceptor(MyInterceptor())
    .build()

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url.newBuilder().addQueryParameter("api_key", Constants.API_KEY).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}

interface AsteroidRadarApiService {
    @GET("neo/rest/v1/feed")
    fun getAsteroidsAsync(
        @Query("start_date") start: String,
        @Query("end_date") end: String
    ): Deferred<List<NetworkAsteroid>>
}

interface PictureOfTheDayService {
    @GET("planetary/apod")
    fun getPictureOfDayAsync(): Deferred<NetworkPictureOfTheDay>
}

object NetworkApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(httpClient)
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