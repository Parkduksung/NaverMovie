package com.sample.rxnaversearchapi.presenter.movie.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.rxnaversearchapi.data.model.MovieItem
import com.sample.rxnaversearchapi.presenter.movie.viewholder.MovieViewHolder

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movieList = mutableListOf<MovieItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
            MovieViewHolder(parent)

    override fun getItemCount(): Int =
        movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bind(movieList[position])

    fun replaceAll(list: List<MovieItem>?) {
        list?.let {
            movieList.apply {
                clear()
                addAll(list)
                notifyDataSetChanged()
            }
        }
    }
}
