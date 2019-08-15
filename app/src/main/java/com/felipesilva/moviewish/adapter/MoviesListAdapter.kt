package com.felipesilva.moviewish.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.adapter.viewholder.MoviesListViewHolder
import com.felipesilva.moviewish.data.model.Movie

class MoviesListAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MoviesListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoviesListViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

}