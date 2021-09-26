package com.udacity.asteroidradar.data.sources.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.data.sources.local.entities.PictureEntity

@Dao
interface PictureDao {

    @Query("select * from picture_of_the_day")
    fun getPictureOfTheDay(): LiveData<PictureEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg pictureEntity: PictureEntity)

    @Query("delete from picture_of_the_day")
    fun clear()
}
