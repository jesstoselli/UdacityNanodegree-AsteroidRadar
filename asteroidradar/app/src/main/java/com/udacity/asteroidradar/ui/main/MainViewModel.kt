package com.udacity.asteroidradar.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.data.repository.AsteroidRepository
import com.udacity.asteroidradar.data.repository.PictureRepository
import com.udacity.asteroidradar.data.sources.local.getDatabase
import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.utils.Event
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val asteroidsRepository = AsteroidRepository(database)
    private val pictureOfTheDayRepository = PictureRepository(database)

    val pictureOfTheDay = pictureOfTheDayRepository.pictureOfTheDay

    lateinit var asteroidsList: LiveData<List<Asteroid>>

    private val _navigateToDetails = MutableLiveData<Event<Asteroid>>()
    val navigateToDetails: LiveData<Event<Asteroid>>
        get() = _navigateToDetails

    init {
        viewModelScope.launch {
            updatePictureOfTheDay()
            updateAsteroidsList()
            populateAsteroidsList()
        }
    }

    private fun updatePictureOfTheDay() {
        viewModelScope.launch {
            pictureOfTheDayRepository.refreshPictureOfTheDay()
        }
    }

    private fun updateAsteroidsList() {
        viewModelScope.launch {
            asteroidsRepository.refreshAsteroidsList()
        }
    }

    private fun populateAsteroidsList() {
        asteroidsList = asteroidsRepository.asteroids
    }

    fun asteroidClicked(asteroid: Asteroid) {
        _navigateToDetails.value = Event(asteroid)
    }
}