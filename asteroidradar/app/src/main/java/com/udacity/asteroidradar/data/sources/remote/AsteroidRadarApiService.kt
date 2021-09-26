package com.udacity.asteroidradar.data.sources.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.network.api.AsteroidRadarResponse
import com.udacity.asteroidradar.domain.NASAImageOfTheDay
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url.newBuilder().addQueryParameter("apikey", Constants.API_KEY).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}

private val httpClient = OkHttpClient.Builder()
    .addInterceptor(MyInterceptor())
    .build()

interface AsteroidRadarApiService {
    @GET("neo/rest/v1/feed")
    fun getNEOFeed(
        @Query("start_date") start: String,
        @Query("end_date") end: String
    ): Deferred<AsteroidRadarResponse>

    @GET("planetary/apod")
    fun getPictureOfDay(): Deferred<NASAImageOfTheDay>
}

object AsteroidRadarApi {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(Constants.BASE_URL)
        .client(httpClient)
        .build()

    val retrofitService: AsteroidRadarApiService by lazy {
        retrofit.create(
            AsteroidRadarApiService::class.java
        )
    }
}