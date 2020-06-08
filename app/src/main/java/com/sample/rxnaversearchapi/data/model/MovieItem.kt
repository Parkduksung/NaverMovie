package com.sample.rxnaversearchapi.data.model

data class MovieItem(
    val actor: String,
    val director: String,
    val image: String,
    val link: String,
    val pubDate: String,
    val subtitle: String,
    val title: String,
    val userRating: String,
    val onItemClick: (MovieItem) -> Unit
) {
    companion object {
        fun of(
            movieItem: MovieItem,
            onItemClick: (MovieItem) -> Unit
        ): MovieItem =
            MovieItem(
                actor = movieItem.actor,
                director = movieItem.director,
                image = movieItem.image,
                link = movieItem.link,
                pubDate = movieItem.pubDate,
                subtitle = movieItem.subtitle,
                title = movieItem.title,
                userRating = movieItem.userRating,
                onItemClick = onItemClick
            )
    }


}
