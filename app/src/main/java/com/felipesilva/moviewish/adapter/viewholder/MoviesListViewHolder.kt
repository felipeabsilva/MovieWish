package com.felipesilva.moviewish.adapter.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felipesilva.moviewish.data.model.Movie
import com.felipesilva.moviewish.utilities.API
import kotlinx.android.synthetic.main.item_movie.view.*
import java.text.SimpleDateFormat
import java.util.*

class MoviesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemMoviePoster = itemView.item_movie_poster
    val itemMovieTitle = itemView.item_movie_title
    val itemReleaseDate = itemView.item_release_date
    val itemOverview = itemView.item_overview

    fun bind(movie: Movie) {
        setImage(itemMoviePoster, movie.posterPath)
        itemMovieTitle.text = movie.title
        itemReleaseDate.text = formatDate(movie.releaseDate)
        itemOverview.text = movie.overview
    }

    fun setImage(imageView: ImageView, path: String?) {
        path?.let {
            Glide.with(imageView.context)
                .load("${API.IMAGE_POSTER_URL}$path")
                .into(imageView)
        }
    }

    fun formatDate(date: Date): String = SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(date)
}