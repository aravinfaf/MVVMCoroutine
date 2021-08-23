package com.aravind.mvvmcoroutine.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.aravind.mvvmcoroutine.R
import com.aravind.mvvmcoroutine.adapter.MovieAdapter
import com.aravind.mvvmcoroutine.databinding.ActivityMainBinding
import com.aravind.mvvmcoroutine.model.Moviemodel
import com.aravind.mvvmcoroutine.source.remote.RetrofitService
import com.aravind.mvvmcoroutine.viewmodel.MovieViewmodel
import com.aravind.mvvmcoroutine.viewmodel.factory.MainViewmodelFactory
import com.aravind.mvvmcoroutine.source.remote.repository.Repository as Repository1

class MainActivity : AppCompatActivity() {

    lateinit var activityMainBinding : ActivityMainBinding
    lateinit var viewmodel : MovieViewmodel
    lateinit var movieAdapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val factory = MainViewmodelFactory(com.aravind.mvvmcoroutine.source.remote.repository.Repository())
        viewmodel = ViewModelProviders.of(this,factory).get(MovieViewmodel::class.java)
        movieAdapter = MovieAdapter()
        activityMainBinding.recyclerview.adapter = movieAdapter

        viewmodel.movielist.observe(this, Observer {
            movieAdapter.setMovies(it)
        })

        viewmodel.loading.observe(this, Observer {
            if (it){
                activityMainBinding.progressDialog.visibility = View.VISIBLE
            }else{
                activityMainBinding.progressDialog.visibility = View.GONE
            }
        })
            viewmodel.getAllmovies()

        viewmodel.error.observe(this,{
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
    }
}