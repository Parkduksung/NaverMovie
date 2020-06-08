package com.sample.rxnaversearchapi.ext

import android.widget.RatingBar
import androidx.databinding.BindingAdapter

@BindingAdapter("bind:setRating")
fun RatingBar.setRating(rating: String?) {
    rating?.let {
        this.rating = rating.toFloat()
    }
}
