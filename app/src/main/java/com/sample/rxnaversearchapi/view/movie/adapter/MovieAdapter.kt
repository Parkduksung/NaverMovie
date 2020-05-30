package com.sample.rxnaversearchapi.view.movie.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.rxnaversearchapi.data.model.MovieItem
import com.sample.rxnaversearchapi.view.movie.adapter.viewholder.MovieViewHolder

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movieList = mutableListOf<MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(parent)

    override fun getItemCount(): Int =
        movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(movieList[position])


    fun addAll(list: List<MovieItem>) {
        movieList.addAll(list)
    }

    fun clear() {
        movieList.clear()
        notifyDataSetChanged()
    }

}