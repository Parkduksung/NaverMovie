package com.sample.rxnaversearchapi.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sample.rxnaversearchapi.R

@BindingAdapter("bind:setUrlImg")
fun ImageView.setUrlImg(url: String?) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .error(R.drawable.alternative_image_until_not_bring)
        .into(this)
}