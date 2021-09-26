package com.udacity.asteroidradar.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.udacity.asteroidradar.data.repository.AsteroidRepository
import com.udacity.asteroidradar.data.repository.PictureRepository
import com.udacity.asteroidradar.data.sources.local.getDatabase
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val database = getDatabase(applicationContext)
        val asteroidRepository = AsteroidRepository(database)
        val pictureRepository = PictureRepository(database)

        return try {
            pictureRepository.refreshPictureOfTheDay()
            asteroidRepository.refreshAsteroidsList()
            asteroidRepository.removeOldAsteroids()
            Result.success()
        } catch (exception: HttpException) {
            Result.retry()
        }
    }


}