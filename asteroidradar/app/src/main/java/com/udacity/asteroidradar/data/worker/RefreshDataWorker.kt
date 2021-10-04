package com.udacity.asteroidradar.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.udacity.asteroidradar.data.repository.AsteroidRepository
import com.udacity.asteroidradar.data.repository.PictureRepository
import com.udacity.asteroidradar.data.sources.local.AsteroidDatabase
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val database = AsteroidDatabase.getDatabase(applicationContext)
        val asteroidRepository = AsteroidRepository(database)
        val pictureRepository = PictureRepository(database)

        return try {
            pictureRepository.refreshPictureOfTheDay()
            asteroidRepository.removeOldAsteroids()
            asteroidRepository.refreshAsteroidsList()
            Result.success()
        } catch (exception: HttpException) {
            Result.retry()
        }
    }
}