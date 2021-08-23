package com.aravind.mvvmcoroutine.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aravind.mvvmcoroutine.model.Moviemodel
import com.aravind.mvvmcoroutine.source.remote.repository.Repository
import kotlinx.coroutines.*

class MovieViewmodel constructor(private val repository: Repository) : ViewModel() {

    val movielist = MutableLiveData<List<Moviemodel>>()
    var error = MutableLiveData<String>()
    var job : Job? =null
    val exceptionHandler = CoroutineExceptionHandler{_,throwable ->
        onError("Exception Handled ${throwable.localizedMessage}")}

    val loading = MutableLiveData<Boolean>()

    fun getAllmovies(){
        job = CoroutineScope(Dispatchers.IO+exceptionHandler).async {
            val response = repository.getAllmovies()
            withContext(Dispatchers.Main){
                if (response?.isSuccessful!!){
                    movielist.postValue(response?.body())
                    loading.value = false
                }else{
                    onError("${response?.message()}")
                }
            }
        }
    }

    private fun onError(s: String) {
        error.value = s
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}