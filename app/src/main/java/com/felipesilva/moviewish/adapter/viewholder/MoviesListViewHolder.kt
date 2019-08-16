package com.felipesilva.moviewish.adapter.viewholder

import android.content.Intent
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felipesilva.moviewish.data.model.Movie
import com.felipesilva.moviewish.utilities.API
import com.felipesilva.moviewish.utilities.SharedParameter
import com.felipesilva.moviewish.utilities.setImageWithGlide
import com.felipesilva.moviewish.view.MovieDetailsActivity
import kotlinx.android.synthetic.main.item_movie.view.*
import java.text.SimpleDateFormat
import java.util.*

class MoviesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemMovie = itemView.item_movie
    val itemMoviePoster = itemView.item_movie_poster
    val itemMovieTitle = itemView.item_movie_title
    val itemReleaseDate = itemView.item_release_date
    val itemOverview = itemView.item_overview

    fun bind(movie: Movie) {
        itemMoviePoster.setImageWithGlide("${API.IMAGE_POSTER_URL}${movie.posterPath}")
        itemMovieTitle.text = movie.title
        itemReleaseDate.text = formatDate(movie.releaseDate)
        itemOverview.text = movie.overview

        itemMovie.setOnClickListener {
            itemView.context.startActivity(
                Intent(itemView.context, MovieDetailsActivity::class.java)
                    .putExtra(SharedParameter.MOVIE_ID, movie.id)
            )
        }
    }

    fun formatDate(date: Date): String = SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(date)
}