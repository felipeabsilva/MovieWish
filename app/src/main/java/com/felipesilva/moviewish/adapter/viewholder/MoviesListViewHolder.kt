package com.felipesilva.moviewish.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.felipesilva.moviewish.data.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemMovieTitle = itemView.item_movie_title

    fun bind(movie: Movie) {
        itemMovieTitle.text = movie.title
    }
}