package com.aravind.mvvmcoroutine.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aravind.mvvmcoroutine.databinding.AdapterMovieBinding
import com.aravind.mvvmcoroutine.model.Moviemodel
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    var movielist = mutableListOf<Moviemodel>()

    fun setMovies(movies : List<Moviemodel>){
        this.movielist = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val inflater =  LayoutInflater.from(parent.context)
        val binding =AdapterMovieBinding.inflate(inflater,parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movielist[position]
        holder.adapterMovieBinding.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.adapterMovieBinding.imageview)
    }

    override fun getItemCount(): Int = movielist.size
}

class MovieViewHolder(val adapterMovieBinding: AdapterMovieBinding) : RecyclerView.ViewHolder(adapterMovieBinding.root)
