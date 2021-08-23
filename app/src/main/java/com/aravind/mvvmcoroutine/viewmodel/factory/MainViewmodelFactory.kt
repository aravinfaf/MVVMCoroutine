package com.aravind.mvvmcoroutine.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aravind.mvvmcoroutine.source.remote.repository.Repository
import com.aravind.mvvmcoroutine.viewmodel.MovieViewmodel
import java.lang.IllegalArgumentException

class MainViewmodelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MovieViewmodel::class.java)){
            return MovieViewmodel(repository) as T
        }

        return IllegalArgumentException("") as T
    }
}