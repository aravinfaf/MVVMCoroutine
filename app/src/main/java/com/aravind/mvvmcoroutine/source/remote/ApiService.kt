package com.aravind.mvvmcoroutine.source.remote

import com.aravind.mvvmcoroutine.model.Moviemodel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movielist.json")
    suspend fun getAllmovies() : Response<List<Moviemodel>>
}