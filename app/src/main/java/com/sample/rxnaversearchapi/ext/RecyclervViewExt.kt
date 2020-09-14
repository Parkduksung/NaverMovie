package com.sample.rxnaversearchapi.ext

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sample.rxnaversearchapi.data.model.MovieItem
import com.sample.rxnaversearchapi.presenter.movie.adapter.MovieAdapter

@BindingAdapter("bind:replaceAll")
fun RecyclerView.replaceAll(list: List<MovieItem>?) {
    @Suppress("UNCHECKED_CAST")
    list?.let {
        (adapter as? MovieAdapter)?.replaceAll(it)
    }
}