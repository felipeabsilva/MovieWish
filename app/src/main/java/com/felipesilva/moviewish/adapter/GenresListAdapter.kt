package com.felipesilva.moviewish.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.adapter.viewholder.GenresListViewHolder
import com.felipesilva.moviewish.data.model.Genre
import com.felipesilva.moviewish.data.model.Genres

class GenresListAdapter(private val genres: List<Genre>) : RecyclerView.Adapter<GenresListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false)
        return GenresListViewHolder(view)
    }

    override fun getItemCount(): Int = genres.size

    override fun onBindViewHolder(holder: GenresListViewHolder, position: Int) {
        val genre = genres[position]
        holder.bind(genre)
    }

}