package com.udacity.asteroidradar.data.sources.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.data.sources.local.entities.AsteroidEntity

@Dao
interface AsteroidDao {

    @Query("select * from asteroids order by date(closeApproachDate) asc")
    fun getAsteroidsFromDatabase(): LiveData<List<AsteroidEntity>>

    @Query("select * from asteroids where closeApproachDate between :startDate and :endDate order by date(closeApproachDate) asc")
    fun getWeeksAsteroids(startDate: String, endDate: String): LiveData<List<AsteroidEntity>>

    @Query("select * from asteroids where closeApproachDate = :date")
    fun getTodaysAsteroids(date: String): LiveData<List<AsteroidEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg asteroids: AsteroidEntity)

    @Query("delete from asteroids where closeApproachDate < :today")
    suspend fun removeOldAsteroidsData(today: String)
}
