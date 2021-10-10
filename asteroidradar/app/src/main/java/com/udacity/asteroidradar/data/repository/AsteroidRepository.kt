package com.udacity.asteroidradar.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroidradar.data.sources.local.AsteroidDatabase
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
import java.time.LocalDate

class AsteroidRepository(private val database: AsteroidDatabase) {

    enum class FilterType {
        WEEK,
        TODAY,
        FROM_DATABASE
    }

    private val _filterType = MutableLiveData(FilterType.WEEK)
    val filterType: LiveData<FilterType>
        get() = _filterType

    @RequiresApi(Build.VERSION_CODES.O)
    private val _startDate = LocalDate.now()

    @RequiresApi(Build.VERSION_CODES.O)
    private val _endDate = _startDate.plusDays(7)

    @RequiresApi(Build.VERSION_CODES.O)
    val asteroids: LiveData<List<Asteroid>> =
        Transformations.switchMap(filterType) { filterType ->
            when (filterType) {
                FilterType.WEEK ->
                    Transformations.map(
                        database.asteroidDao.getWeeksAsteroids(
                            _startDate.toString(),
                            _endDate.toString()
                        )
                    ) {
                        it.toDomainModel()
                    }

                FilterType.TODAY ->
                    Transformations.map(database.asteroidDao.getTodaysAsteroids(_startDate.toString())) {
                        it.toDomainModel()
                    }

                FilterType.FROM_DATABASE ->
                    Transformations.map(database.asteroidDao.getAsteroidsFromDatabase()) {
                        it.toDomainModel()
                    }

                else -> throw IllegalArgumentException("Something went wrong while filtering the results.")
            }
        }

    fun filtering(filterType: FilterType) {
        _filterType.value = filterType
    }

    // Refresh the picture stored in offline cache
    suspend fun refreshAsteroidsList(
        startDate: String = getTodaysDateFormatted(),
        endDate: String = getOneWeekFromNowWithDateFormatted()
    ) {
        var asteroidsList: ArrayList<Asteroid>

        withContext(Dispatchers.IO) {
            try {
                val asteroidResponseBody =
                    NetworkApi.asteroidService.getAsteroidsAsync(startDate, endDate).await()

                asteroidsList = parseAsteroidsJsonResult(JSONObject(asteroidResponseBody.string()))

                database.asteroidDao.insertAll(*asteroidsList.toDatabaseModel())
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Timber.d("Refresh failed ${e.message}")
                }
                e.printStackTrace()
            }
        }
    }


//    suspend fun refreshAsteroidsList() {
//        withContext(Dispatchers.IO) {
//            try {
//                val startDate: String = getTodaysDateFormatted()
//                val endDate: String = getOneWeekFromNowWithDateFormatted()
//
//                val asteroidsResponse =
//                    NetworkApi.asteroidService.getAsteroidsAsync(startDate, endDate)
//
//                val parseAsteroids =
//                    parseAsteroidsJsonResult(JSONObject(asteroidsResponse.toString()))
//
//                database.asteroidDao.insertAll(*parseAsteroids.toDatabaseModel())
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    Timber.d("Refresh failed ${e.message}")
//                }
//                e.printStackTrace()
//            }
//        }
//    }

    suspend fun removeOldAsteroids() {
        withContext(Dispatchers.IO) {
            database.asteroidDao.removeOldAsteroidsData(getTodaysDateFormatted())
        }
    }
}