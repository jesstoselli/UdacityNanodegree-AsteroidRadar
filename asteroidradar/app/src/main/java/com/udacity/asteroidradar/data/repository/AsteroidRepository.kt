package com.udacity.asteroidradar.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroidradar.data.sources.local.AsteroidDatabase
import com.udacity.asteroidradar.data.sources.local.entities.AsteroidEntity
import com.udacity.asteroidradar.data.sources.local.toDatabaseModel
import com.udacity.asteroidradar.data.sources.local.toDomainModel
import com.udacity.asteroidradar.data.sources.remote.NetworkApi
import com.udacity.asteroidradar.data.sources.remote.getOneWeekFromNowWithDateFormatted
import com.udacity.asteroidradar.data.sources.remote.getTodaysDateFormatted
import com.udacity.asteroidradar.data.sources.remote.parseAsteroidsJsonResult
import com.udacity.asteroidradar.domain.Asteroid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import timber.log.Timber

class AsteroidRepository(private val database: AsteroidDatabase) {

    val asteroids: LiveData<List<Asteroid>> =
        Transformations.map(database.asteroidDao.getAllAsteroids()) {
            it.toDomainModel()
        }

    fun getAllAsteroids(): LiveData<List<AsteroidEntity>> {
        return database.asteroidDao.getAllAsteroids()
    }

    fun getAsteroidsByCloseApproachDate(
        startDate: String,
        endDate: String
    ): LiveData<List<AsteroidEntity>> {
        return database.asteroidDao.getAsteroidsByCloseApproachDate(startDate, endDate)
    }

    // Refresh the picture stored in offline cache
    suspend fun refreshAsteroidsList(
        startDate: String = getTodaysDateFormatted(),
        endDate: String = getOneWeekFromNowWithDateFormatted()
    ) {
        var asteroidsList: ArrayList<Asteroid>

        withContext(Dispatchers.IO) {
            try {
                val asteroidResponseBody = NetworkApi.asteroidService.getAsteroidsAsync(startDate, endDate).await()

                asteroidsList = parseAsteroidsJsonResult(JSONObject(asteroidResponseBody.string()))

                Timber.i("Asteroids List => $asteroidsList")

                database.asteroidDao.insertAll(*asteroidsList.toDatabaseModel())
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