package com.udacity.asteroidradar.data.repository

import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroidradar.data.sources.local.AsteroidDatabase
import com.udacity.asteroidradar.data.sources.local.toDatabaseModel
import com.udacity.asteroidradar.data.sources.local.toDomainModel
import com.udacity.asteroidradar.data.sources.remote.NetworkApi
import com.udacity.asteroidradar.data.sources.remote.getOneFromNowWithDateFormatted
import com.udacity.asteroidradar.data.sources.remote.getTodaysDateFormatted
import com.udacity.asteroidradar.data.sources.remote.parseAsteroidsJsonResult
import com.udacity.asteroidradar.domain.Asteroid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import timber.log.Timber

class AsteroidRepository(private val database: AsteroidDatabase) {

    val asteroids: LiveData<List<Asteroid>> =
        Transformations.map(database.asteroidDao.getSavedAsteroidData()) {
            it.toDomainModel()
        }

//    fun getSavedAsteroidData(): LiveData<List<AsteroidEntity>>
//
//    fun getTodaysAsteroids(date: String): LiveData<List<AsteroidEntity>>
//
//    fun getWeeksAsteroids(startDate: String, endDate: String): LiveData<List<AsteroidEntity>>



    // Refresh the picture stored in offline cache
    suspend fun refreshAsteroidsList() {
        withContext(Dispatchers.IO) {
            try {
                val startDate = getTodaysDateFormatted()
                val endDate = getOneFromNowWithDateFormatted()
                val asteroidsList = NetworkApi.asteroidService.getAsteroidsAsync(startDate, endDate).await()

                val parsedAsteroids = parseAsteroidsJsonResult(JSONObject(asteroidsList.toString()))

                Timber.i("Asteroids List => $asteroidsList")

                database.asteroidDao.insertAll(*parsedAsteroids.toDatabaseModel())
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Timber.d("Refresh failed ${e.message}")
                }
                e.printStackTrace()
            }
        }
    }

    suspend fun removeOldAsteroids() {
        withContext(Dispatchers.IO) {
            database.asteroidDao.removeOldAsteroidsData(getTodaysDateFormatted())
        }
    }
}