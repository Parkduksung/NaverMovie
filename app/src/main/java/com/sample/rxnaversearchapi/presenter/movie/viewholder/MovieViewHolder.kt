package com.sample.rxnaversearchapi.presenter.movie.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.rxnaversearchapi.BR
import com.sample.rxnaversearchapi.R
import com.sample.rxnaversearchapi.data.model.MovieItem
import com.sample.rxnaversearchapi.databinding.ItemMovieBinding

class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.item_movie, parent, false
    )
) {
    private val binding =
        DataBindingUtil.bind<ItemMovieBinding>(itemView)

    fun bind(item: MovieItem) {
        binding?.run {
            setVariable(BR.movieItem, item)
            executePendingBindings()
        }
    }
}