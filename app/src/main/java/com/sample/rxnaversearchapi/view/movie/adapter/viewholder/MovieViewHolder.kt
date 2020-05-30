package com.sample.rxnaversearchapi.view.movie.adapter.viewholder

import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
        binding?.apply {
            tvTitle.text = item.title
            tvSubtitle.text = Html.fromHtml(item.subtitle, FROM_HTML_MODE_LEGACY)
            tvDirector.text = item.director
            tvActor.text = item.actor
            tvRating.text = item.userRating
            Glide.with(itemView)
                .load(item.image)
                .circleCrop()
                .into(ivImage)
        }
    }
}