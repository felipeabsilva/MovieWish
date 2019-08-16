package com.felipesilva.moviewish.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.felipesilva.moviewish.data.model.Genre
import kotlinx.android.synthetic.main.item_genre.view.*

class GenresListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val genreTitle = itemView.text_genre_title

    fun bind(genre: Genre) {
        genreTitle.text = genre.name
    }
}