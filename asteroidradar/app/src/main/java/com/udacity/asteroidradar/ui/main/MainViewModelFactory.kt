package com.udacity.asteroidradar.ui.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Factory for constructing MainViewModel with parameter
 */
class MainViewModelFactory (private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}