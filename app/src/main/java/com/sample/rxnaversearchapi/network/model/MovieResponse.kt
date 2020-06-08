package com.sample.rxnaversearchapi.network.model


import android.widget.Toast
import com.google.gson.annotations.SerializedName
import com.sample.rxnaversearchapi.App
import com.sample.rxnaversearchapi.data.model.MovieItem

data class MovieResponse(
    @SerializedName("actor")
    val actor: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("pubDate")
    val pubDate: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("userRating")
    val userRating: String
) {
    fun toMovieItem(): MovieItem =
        MovieItem(
            actor,
            director,
            image,
            link,
            pubDate,
            subtitle,
            title,
            userRating,
            onItemClick = {
                Toast.makeText(App.instance.context(), it.link, Toast.LENGTH_SHORT).show()
            }
        )
}