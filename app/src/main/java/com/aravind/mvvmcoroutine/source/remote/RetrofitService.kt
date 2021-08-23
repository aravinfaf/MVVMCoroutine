package com.aravind.mvvmcoroutine.source.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitService {

    companion object{
        var retrofit : Retrofit? = null

        fun getInstance() : Retrofit? {

            if (retrofit == null){
                 retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
    }

}