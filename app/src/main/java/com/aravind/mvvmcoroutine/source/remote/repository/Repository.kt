package com.aravind.mvvmcoroutine.source.remote.repository

import com.aravind.mvvmcoroutine.source.remote.ApiService
import com.aravind.mvvmcoroutine.source.remote.RetrofitService

class Repository  {

    private val retrofitService = RetrofitService.getInstance()?.create(ApiService::class.java)

    suspend fun getAllmovies() = retrofitService?.getAllmovies()
}