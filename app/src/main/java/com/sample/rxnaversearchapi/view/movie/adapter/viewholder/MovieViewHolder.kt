package com.sample.rxnaversearchapi.view.movie.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.rxnaversearchapi.BR
import com.sample.rxnaversearchapi.R
import com.sample.rxnaversearchapi.data.model.MovieItem
import com.sample.rxnaversearchapi.databinding.MovieItemBinding

class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.movie_item, parent, false
    )
) {
    private val binding =
        DataBindingUtil.bind<MovieItemBinding>(itemView)

    fun bind(item: MovieItem) {
        binding?.run {
            setVariable(BR.VM, item)
            executePendingBindings()
        }
    }
}